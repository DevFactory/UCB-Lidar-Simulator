package monochromator;

public class Monochromator {
    private double overlapFactor;
    private double M;   //PMT Multiplication factor
    private double F;   //PMT Excess noise factor
    private double Ids; //Surface Dark Current
    private double Rio; //Cathode Sensitivity
    private double Ida; //PMT Anode dark current
    private double Idb; //Bulk Dark Current
    private double R;   //Transducer gain
    private double GT;
    private double Nv;
    private double sigampA; //Current noise density
    private double B;   //Preamplifier limits
    private double k = 1.38e-23;                    // Boltzmann's constant [J·K-1]
    private double T = 300;         //Equivalent Noise Temperature,T=300[K]
    private String apdName;

    public Monochromator() {
        this.overlapFactor = 1;
    }

    public Monochromator(int overlapFactor) {
        this.overlapFactor = overlapFactor;
    }

    //First and second APD Constructor
    public Monochromator(double m, double f, double ids, double rio, double ida, double idb, double r, String apdName) {
        this.apdName = apdName;
        this.overlapFactor = 1;
        this.M = m;
        this.F = f;
        this.Ids = ids;
        this.Rio = rio;
        this.Ida = ida;
        this.Idb = idb;
        this.R = r;
        this.GT = this.R;
        this.Nv = 4 * this.k * this.T * this.R;
    }

    public Monochromator(double multiplicationFactor, double excessNoiseFactor, double surfaceDarkCurrent, double cathodeSensitivity, double anodeDarkCurrent, double bulkDarkCurrent, double transducerGain, double preamplifierLimits, double currentNoiseDensity, String apdName) {
        this.apdName = apdName;
        this.overlapFactor = 1;
        this.M = multiplicationFactor;
        this.F = excessNoiseFactor;
        this.Ids = surfaceDarkCurrent;
        this.Rio = cathodeSensitivity;
        this.Ida = anodeDarkCurrent;
        this.Idb = bulkDarkCurrent;
        this.R = transducerGain;
        this.sigampA = currentNoiseDensity;
        this.B = preamplifierLimits;
        this.Nv = 4 * this.k * this.T * this.R;
    }

    //Third and fourth APD Constructor
    public Monochromator(double m, double f, double ids, double rio, double idb, double b, double sigampa, double gt, String apdName) {
        this.apdName = apdName;
        this.overlapFactor = 1;
        this.M = m;
        this.F = f;
        this.Ids = ids;
        this.Rio = rio;
        this.Idb = idb;
        this.B = b;
        this.sigampA = sigampa;
        this.GT = gt;
        this.Nv = Math.pow(this.sigampA, 2) * Math.pow(this.GT, 2);
    }


    public double getOverlapFactor() {
        return overlapFactor;
    }

    public void setOverlapFactor(double overlapFactor) {
        this.overlapFactor = overlapFactor;
    }

    public double getM() {
        return M;
    }

    public void setM(double m) {
        M = m;
    }

    public double getF() {
        return F;
    }

    public void setF(double f) {
        F = f;
    }

    public double getIds() {
        return Ids;
    }

    public void setIds(double ids) {
        Ids = ids;
    }

    public double getRio() {
        return Rio;
    }

    public void setRio(double rio) {
        Rio = rio;
    }

    public double getIda() {
        return Ida;
    }

    public void setIda(double ida) {
        Ida = ida;
    }

    public double getIdb() {
        return Idb;
    }

    public void setIdb(double idb) {
        Idb = idb;
    }

    public double getR() {
        return R;
    }

    public void setR(double r) {
        R = r;
    }

    public double getGT() {
        return GT;
    }

    public void setGT(double GT) {
        this.GT = GT;
    }

    public double getNv() {
        return Nv;
    }

    public void setNv(double nv) {
        Nv = nv;
    }

    public double getSigampA() {
        return sigampA;
    }

    public void setSigampA(double sigampA) {
        this.sigampA = sigampA;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getT() {
        return T;
    }

    public void setT(double t) {
        T = t;
    }

    public String getApdName() {
        return apdName;
    }

    public void setApdName(String apdName) {
        this.apdName = apdName;
    }
}
