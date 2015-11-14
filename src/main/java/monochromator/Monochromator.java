package monochromator;

/**
 * Created by Oscar on 9/14/15.
 */
public class Monochromator {
    private int overlapFactor;
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

    public Monochromator() {
        this.overlapFactor = 1;
    }

    public Monochromator(int overlapFactor) {
        this.overlapFactor = overlapFactor;
    }

    public int getOverlapFactor() {
        return overlapFactor;
    }

    public void setOverlapFactor(int overlapFactor) {
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
}
