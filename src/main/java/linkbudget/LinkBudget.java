package linkbudget;

import atmosphere.Rayleigh;
import helpers.IntegralSolver;
import laser.Laser;
import monochromator.Monochromator;
import telescope.Telescope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by Oscar on 9/30/15.
 */
public class LinkBudget {

    private double L;
    private Telescope telescope;
    private Monochromator monochromator;
    private Rayleigh rayleigh;
    private Laser laser;
    private ArrayList<Double> r; //Range Vector
    private ArrayList<Number> altitudes;
    private ArrayList<Double> results;

    //Physical Constants
    private double q = 1.602e-19;                // Electron charge [C]
    private double h = 6.6262e-34;                // Planck's constant [J·s]
    private double c = 2.99793e8;                // Light speed [m/s]
    private double k = 1.38e-23;                    // Boltzmann's constant [J·K-1]
    private double T = 300;                        // Equivalent Noise Temperature, T=300 [K]
    private double t0 = 15;                        // Atmospheric Temperature at 0 m [Celsius] -2(last)
    private double p0 = 1013.15;                    // Atmospheric Pressure at 0 m [mb] 1025(last)
    private double nSamples;
    private double rMin;
    private double rMax;
    private double delta;
    private double nMie;
    private double rPBL;
    private double fOVF;
    private double ovf;
    //System Constants
    //TELESCOPE
    //private double deq = 0.2032;                // Telescope diameter = 0.35545 [m] 	(Gelso = 1 [m], Celestron = 0.2032 [m])
    //private double dsh = 0.06858;                // Telescope shadow diameter [m]  (Celestron = 0.06858 [m])
    //private double focus = 2;                    // Telescope focal length (m)

    //LASER
    //private double div0 = 0.5e-3;                // Laser beam divergence (semiangle) [srad]
    private double d0;                             // Laser-to-telescope axis separation [Celestron (deq/2+5e-2= 15e-2 [m])] (Gelso = 65e-2 [m])

    private double Ar;                             // Telescope effective area [m2]
    private double dFiber;                         // 3M Fiber core diameter 1.5e-3[m] WARNING: POWER LOSS!
    private double fov;                            //Telescope FOV (semiangle), NA=0.12 %Celestron, Dapd/(2*focus)=7.5e-4 rad
    private double dOmega;                         // Solid angle
    private double w0;                             //Laser beam waist radius (5e-3) [m]
    private double tilt;                           // Laser-to-telescope tilt angle [rad]
    private double nOvf;
    private IntegralSolver integralSolver;
    private double dLambda0;
    private double powb0;
    private double Ri;                             //APD Current responsivity
    private double loss0;
    private double Rv;
    private double cons0;
    private ArrayList<Double> s0;
    private double B;
    private double a0;
    private double snrgoal;
    private double PRF;
    private double b0;
    private double c0;
    private ArrayList<Double> Nshs0;
    private double Nshd0;
    private double Nth;
    private double NEP_0;
    private double NEPs_0;
    private ArrayList<Double> SNR0;
    private double in0;
    private double snrint;


    public LinkBudget() {
        this.telescope = new Telescope();
        this.monochromator = new Monochromator();
        this.rayleigh = new Rayleigh();
    }

    public void initializeComponents() {
        this.Ar = Math.PI * ((Math.pow((this.telescope.getDiameter() / 2), 2)) - (Math.pow((this.telescope.getShadeDiameter() / 2), 2)));
        this.d0 = this.telescope.getDiameter() / 2 + 5e-2;
        this.dFiber = 3e-3;
        this.fov = dFiber / (2 * this.telescope.getFocalLength());
        this.dOmega = Math.PI * Math.pow(Math.sin(this.fov), 2);
        this.w0 = 5e-3;
        this.tilt = 0;
        rMin = this.altitudes.get(0).doubleValue();
        rMax = this.altitudes.get(this.altitudes.size() - 1).doubleValue();
        this.rPBL = 500;
        this.fOVF = 1;
        this.snrint = 1;
    }

    public void backgroundComponent() {
        this.L = 3.0e-11;
        this.dLambda0 = 10;
        this.B = 10e6;
        this.snrgoal = 1;
        this.PRF = 20;
    }


    public void rangeCalculations() {
        this.r = linspace(this.rMin, this.rMax, this.nSamples);
        this.delta = this.r.get(1) - this.r.get(0);
        this.nSamples = this.r.size();
        this.nMie = Math.floor((this.rPBL - this.rMin) / this.delta);
    }

    public void powerLevelCalculations() {
        this.ovf = this.monochromator.getOverlapFactor();
        this.nOvf = 1;
        if (this.r.get(0) == 1) {
            generate();
        }
        this.powb0 = this.L * 1e4 * this.dLambda0 * this.Ar * this.dOmega;
    }

    public void elasticSNR() {
        this.Ri = this.monochromator.getRio() * this.monochromator.getM();
        this.Rv = this.Ri * this.monochromator.getGT();
        this.cons0 = this.Rv * this.loss0;
        s0 = s0Generation(this.cons0, this.results);
        this.a0 = 2 * this.q * Math.pow(this.monochromator.getGT(), 2) * this.monochromator.getF() * Math.pow(this.monochromator.getM(), 2) * this.monochromator.getRio() * this.loss0 * this.B;
        this.b0 = 2 * this.q * Math.pow(this.monochromator.getGT(), 2) * (this.monochromator.getIds() + this.monochromator.getIdb() * this.monochromator.getF() * Math.pow(this.monochromator.getM(), 2)) * this.B;
        this.c0 = this.monochromator.getNv() * this.B;
        this.Nshs0 = nshs0Generation(this.a0, this.results, this.powb0);
        this.Nshd0 = this.b0;
        this.Nth = this.c0;
        this.NEP_0 = Math.sqrt(2 * this.q * (this.monochromator.getIds() + this.monochromator.getF() * (Math.pow(this.monochromator.getM(), 2)) * this.monochromator.getIdb())) / this.Ri;
        this.NEPs_0 = Math.sqrt(2 * this.q * (this.monochromator.getIds() + this.monochromator.getF() * (Math.pow(this.monochromator.getM(), 2)) * this.monochromator.getIdb()) + (this.monochromator.getNv() / Math.pow(this.monochromator.getGT(), 2))) / (this.Ri * this.loss0);
        this.SNR0 = snr0Generation();

        /* Elastic channel integration pulses to achieve SNR=snrint */
        ArrayList<Double> helper = findFunction(this.SNR0);
        this.in0 = helper.indexOf(Collections.min(helper));
//        this.niE = this.snrint/ ;

    }

    private ArrayList<Double> findFunction(ArrayList<Double> array) {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > 0) {
                aux.add(array.get(i));
            }
        }
        return aux;
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
        for (int i = 0; i <= this.results.size(); i++) {
            aux.add(this.powb0 + this.results.get(i));
        }
        return aux;
    }

    private ArrayList s0Generation(double cons0, ArrayList<Double> results) {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int i = 0; i <= this.results.size(); i++) {
            aux.add(cons0 * this.results.get(i));
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
            this.results.add(aux);
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
}
