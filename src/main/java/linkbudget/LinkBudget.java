package linkbudget;

import atmosphere.Atmosphere;
import atmosphere.Mie;
import atmosphere.Rayleigh;
import helpers.IntegralSolver;
import laser.Laser;
import monochromator.Monochromator;
import telescope.Telescope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Oscar on 9/30/15.
 */
public class LinkBudget {


    private Telescope telescope;
    private Monochromator monochromator;
    private Rayleigh rayleigh;
    private Laser laser;
    private IntegralSolver integralSolver;
    private Mie mie;
    private Atmosphere atmosphere;
    private ArrayList<Double> r; //Range Vector
    private ArrayList<Number> altitudes;
    private ArrayList<Double> pow0; //Optical Return Powers
    private ArrayList<Double> Nshs0;
    private ArrayList<Double> SNR0; //Signal To Noise Ratio
    private ArrayList<Double> s0;
    private double L;       //Radiance in [W·cm-2·nm-1·sr-1] (p.225 Measures y p.197 IR/EO Vol.1) 77º.
    private double k;           //System Constant
    private double c;                // Light speed [m/s]
    private double Ar;                             // Telescope effective area [m2]
    private double dFiber;                         // 3M Fiber core diameter 1.5e-3[m] WARNING: POWER LOSS!
    private double fov;                            //Telescope FOV (semiangle), NA=0.12 %Celestron, Dapd/(2*focus)=7.5e-4 rad
    private double dOmega;                         // Solid angle
    private double rMin;
    private double rMax;
    private double rPBL;
    private double dLambda0;
    private double B;
    private double q = 1.602e-19;                // Electron charge [C]
    //private double k = 1.38e-23;                    // Boltzmann's constant [J·K-1]
    private double nSamples;
    private double ovf;
    private double powb0;
    private double Ri;                             //APD Current responsivity
    private double loss0;
    private double Rv;
    private double cons0;
    private double a0;
    private double b0;
    private double c0;
    private double Nshd0;
    private double Nth;
    private double NEP_0;
    private double NEPs_0;



    public LinkBudget() {
        this.mie = new Mie();
        this.telescope = new Telescope();
        this.monochromator = new Monochromator();
        this.rayleigh = new Rayleigh();
        this.laser = new Laser();
        this.integralSolver = new IntegralSolver();
        this.integralSolver.setFunction(this.mie);
        this.c = 2.99793e8;
        initializeComponents();
    }

    public LinkBudget(Laser laser, Monochromator monochromator, Telescope telescope, Atmosphere atmosphere, ArrayList<Number> altitudes) {
        this.integralSolver = new IntegralSolver();
        this.laser = laser;
        this.monochromator = monochromator;
        this.telescope = telescope;
        this.atmosphere = atmosphere;
        this.mie = this.atmosphere.getMie();
        this.rayleigh = this.atmosphere.getRayleigh();
        this.altitudes = altitudes;
        this.integralSolver.setFunction(this.mie);
        this.c = 2.99793e8;
        initializeComponents();
    }

    public void initializeComponents() {
        this.Ar = Math.PI * ((Math.pow((this.telescope.getDiameter() / 2), 2)) - (Math.pow((this.telescope.getShadeDiameter() / 2), 2)));
        this.k = ((this.laser.getEnergy() * this.c) / 2) * this.Ar;
        this.dFiber = 3e-3;
        this.fov = this.dFiber / (2 * this.telescope.getFocalLength());
        this.dOmega = Math.PI * Math.pow(Math.sin(this.fov), 2);
        rMin = this.altitudes.get(0).doubleValue();
        rMax = this.altitudes.get(this.altitudes.size() - 1).doubleValue();
        this.rPBL = 0.500;
        backgroundComponent();
        rangeCalculations();
        powerLevelCalculations();
        elasticSNR();
    }

    public void backgroundComponent() {
        this.L = 3.0e-11;
        this.dLambda0 = 10;
        this.B = 10e6;
    }

    public void rangeCalculations() {
        this.r = linspace(this.rMin, this.rMax, this.nSamples);
        this.nSamples = this.r.size();
    }

    public void powerLevelCalculations() {
        this.ovf = this.monochromator.getOverlapFactor();
        if (this.r.get(0) == 1) {
            generate();
        }
        this.powb0 = this.L * 1e4 * this.dLambda0 * this.Ar * this.dOmega;
    }

    public void elasticSNR() {
        this.Ri = this.monochromator.getRio() * this.monochromator.getM();
        this.Rv = this.Ri * this.monochromator.getGT();
        this.cons0 = this.Rv * this.loss0;

        s0 = s0Generation(this.cons0, this.pow0);
        this.a0 = 2 * this.q * Math.pow(this.monochromator.getGT(), 2) * this.monochromator.getF() * Math.pow(this.monochromator.getM(), 2) * this.monochromator.getRio() * this.loss0 * this.B;
        this.b0 = 2 * this.q * Math.pow(this.monochromator.getGT(), 2) * (this.monochromator.getIds() + this.monochromator.getIdb() * this.monochromator.getF() * Math.pow(this.monochromator.getM(), 2)) * this.B;
        this.c0 = this.monochromator.getNv() * this.B;
        this.Nshs0 = nshs0Generation(this.a0, this.pow0, this.powb0);
        this.Nshd0 = this.b0;
        this.Nth = this.c0;

        this.NEP_0 = Math.sqrt(2 * this.q * (this.monochromator.getIds() + this.monochromator.getF() * (Math.pow(this.monochromator.getM(), 2)) * this.monochromator.getIdb())) / this.Ri;
        this.NEPs_0 = Math.sqrt(2 * this.q * (this.monochromator.getIds() + this.monochromator.getF() * (Math.pow(this.monochromator.getM(), 2)) * this.monochromator.getIdb()) + (this.monochromator.getNv() / Math.pow(this.monochromator.getGT(), 2))) / (this.Ri * this.loss0);
        this.SNR0 = snr0Generation();
    }

    private ArrayList<Double> snr0Generation() {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int i = 0; i <= this.Nshs0.size(); i++) {
            aux.add(this.s0.get(i) / (this.Nshs0.get(i).doubleValue() + this.Nshd0 + this.Nth));
        }
        return aux;
    }


    private ArrayList<Double> nshs0Generation(double a0, ArrayList<Double> results, double powb0) {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int i = 0; i <= this.pow0.size(); i++) {
            aux.add(this.powb0 + this.pow0.get(i));
        }
        return aux;
    }

    private ArrayList s0Generation(double cons0, ArrayList<Double> results) {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int i = 0; i <= this.pow0.size(); i++) {
            aux.add(cons0 * this.pow0.get(i));
        }
        return aux;
    }

    public void generate() {
        double aux;
        Iterator<Number> backScatterIterator = this.rayleigh.getBetaScattering().iterator();
        Iterator<Number> altitudesIterator = this.altitudes.iterator();

        while (backScatterIterator.hasNext()) {
            float backscatter = backScatterIterator.next().floatValue();
            float altitude = altitudesIterator.next().floatValue();
            aux = opticalReturnPower(altitude, backscatter);
            this.pow0.add(aux);
        }
    }

    public double opticalReturnPower(double altitude, double backscatterCoef) {
        double value = Math.pow(((this.k / Math.pow(altitude, 2)) * backscatterCoef), (-2 * this.integralSolver.integration(0.0, altitude
        ) * this.ovf)); //this.monochromator.getOverlapFactor()));
        return value;
    }

    public ArrayList<Double> linspace(double min, double max, double samplesQTY) {
        ArrayList<Double> aux = new ArrayList<Double>();
        double dx = (max - min) / (samplesQTY - 1);
        for (int i = 0; i < samplesQTY; i++) {
            aux.add(min + (i * dx));
        }
        return aux;
    }

    public Telescope getTelescope() {
        return telescope;
    }

    public void setTelescope(Telescope telescope) {
        this.telescope = telescope;
    }

    public Monochromator getMonochromator() {
        return monochromator;
    }

    public void setMonochromator(Monochromator monochromator) {
        this.monochromator = monochromator;
    }

    public Rayleigh getRayleigh() {
        return rayleigh;
    }

    public void setRayleigh(Rayleigh rayleigh) {
        this.rayleigh = rayleigh;
    }

    public Laser getLaser() {
        return laser;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }

    public IntegralSolver getIntegralSolver() {
        return integralSolver;
    }

    public void setIntegralSolver(IntegralSolver integralSolver) {
        this.integralSolver = integralSolver;
    }

    public Mie getMie() {
        return mie;
    }

    public void setMie(Mie mie) {
        this.mie = mie;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public ArrayList<Double> getR() {
        return r;
    }

    public void setR(ArrayList<Double> r) {
        this.r = r;
    }

    public ArrayList<Number> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(ArrayList<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public ArrayList<Double> getPow0() {
        return pow0;
    }

    public void setPow0(ArrayList<Double> pow0) {
        this.pow0 = pow0;
    }

    public ArrayList<Double> getNshs0() {
        return Nshs0;
    }

    public void setNshs0(ArrayList<Double> nshs0) {
        Nshs0 = nshs0;
    }

    public ArrayList<Double> getSNR0() {
        return SNR0;
    }

    public void setSNR0(ArrayList<Double> SNR0) {
        this.SNR0 = SNR0;
    }

    public ArrayList<Double> getS0() {
        return s0;
    }

    public void setS0(ArrayList<Double> s0) {
        this.s0 = s0;
    }

    public double getL() {
        return L;
    }

    public void setL(double l) {
        L = l;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getAr() {
        return Ar;
    }

    public void setAr(double ar) {
        Ar = ar;
    }

    public double getdFiber() {
        return dFiber;
    }

    public void setdFiber(double dFiber) {
        this.dFiber = dFiber;
    }

    public double getFov() {
        return fov;
    }

    public void setFov(double fov) {
        this.fov = fov;
    }

    public double getdOmega() {
        return dOmega;
    }

    public void setdOmega(double dOmega) {
        this.dOmega = dOmega;
    }

    public double getrMin() {
        return rMin;
    }

    public void setrMin(double rMin) {
        this.rMin = rMin;
    }

    public double getrMax() {
        return rMax;
    }

    public void setrMax(double rMax) {
        this.rMax = rMax;
    }

    public double getrPBL() {
        return rPBL;
    }

    public void setrPBL(double rPBL) {
        this.rPBL = rPBL;
    }

    public double getdLambda0() {
        return dLambda0;
    }

    public void setdLambda0(double dLambda0) {
        this.dLambda0 = dLambda0;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getnSamples() {
        return nSamples;
    }

    public void setnSamples(double nSamples) {
        this.nSamples = nSamples;
    }

    public double getOvf() {
        return ovf;
    }

    public void setOvf(double ovf) {
        this.ovf = ovf;
    }

    public double getPowb0() {
        return powb0;
    }

    public void setPowb0(double powb0) {
        this.powb0 = powb0;
    }

    public double getRi() {
        return Ri;
    }

    public void setRi(double ri) {
        Ri = ri;
    }

    public double getLoss0() {
        return loss0;
    }

    public void setLoss0(double loss0) {
        this.loss0 = loss0;
    }

    public double getRv() {
        return Rv;
    }

    public void setRv(double rv) {
        Rv = rv;
    }

    public double getCons0() {
        return cons0;
    }

    public void setCons0(double cons0) {
        this.cons0 = cons0;
    }

    public double getA0() {
        return a0;
    }

    public void setA0(double a0) {
        this.a0 = a0;
    }

    public double getB0() {
        return b0;
    }

    public void setB0(double b0) {
        this.b0 = b0;
    }

    public double getC0() {
        return c0;
    }

    public void setC0(double c0) {
        this.c0 = c0;
    }

    public double getNshd0() {
        return Nshd0;
    }

    public void setNshd0(double nshd0) {
        Nshd0 = nshd0;
    }

    public double getNth() {
        return Nth;
    }

    public void setNth(double nth) {
        Nth = nth;
    }

    public double getNEP_0() {
        return NEP_0;
    }

    public void setNEP_0(double NEP_0) {
        this.NEP_0 = NEP_0;
    }

    public double getNEPs_0() {
        return NEPs_0;
    }

    public void setNEPs_0(double NEPs_0) {
        this.NEPs_0 = NEPs_0;
    }
}
