package telescope;

/**
 * Created by Oscar on 6/30/15.
 */
public class Telescope {
    private double d1;//primary mirror diameter
    private double d2;//secondary mirror diameter
    private double f1;//primary mirror focal length
    private double d;//Separation between mirrors
    private double q;//System focal point to secondary mirror distance
    private double e;//Primary mirror surface to focal plane distance
    private double p;//distance from the secondary surface to the focal point of the primary
    private double systemFocalLength;//System Focal Length - F
    private double magnification; //Magnification - M
    private double curvatureRadius2;//Radius of curvature from secondary mirror - R2
    private double s;
    private double k1 = -1;//Conic constant for primary mirror
    private double k2;//Conic constant for secondary mirror
    private double qp;
    private double qR2;
    private double Ar; //Effective Telescope Area

    public Telescope() {
    }

    public Telescope(double d2, double d1, double f1, double d, double q, double e, double p) {
        this.d2 = d2;
        this.d1 = d1;
        this.f1 = f1;
        this.d = d;
        this.q = q;
        this.e = e;
        this.p = p;
    }

    public double getAr() {
        return Ar;
    }

    public void setAr(double ar) {
        Ar = ar;
    }

    public void computeSystemFocalLength() {
        this.systemFocalLength = this.f1 * this.magnification;
    }

    public void computeSystemMagnification() {
        this.magnification = this.q / this.p;
    }

    public void computeP() {
        this.p = (this.f1 + this.e) / (this.magnification + 1);
    }

    public void computeR2() {
        this.curvatureRadius2 = 2 * this.p * this.magnification / (this.magnification - 1);
    }


    public void computeD2() {
        this.d2 = this.d1 * this.p / this.f1;
    }

    public void computeS() {
        this.s = this.q / this.d;
    }

    public void computeK2() {
        this.k2 = (((-4 * this.magnification) / (Math.pow(this.magnification - 1, 2.0))) - 1);
    }

    public void computeQP() {
        this.qp = Math.pow(this.curvatureRadius2, 2.0) / (4 * Math.pow(this.p, 2.0) - 4 * this.p * curvatureRadius2 + Math.pow(this.curvatureRadius2, 2));
    }

    public void computeQR2() {
        this.qR2 = this.p / (this.curvatureRadius2 - 2 * this.p) - this.curvatureRadius2 * this.p / (Math.pow(this.curvatureRadius2 - 2 * this.p, 2));
    }

    public void computeQ() {
        this.q = this.curvatureRadius2 * this.p / (this.curvatureRadius2 - 2 * this.p);
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    public double getF1() {
        return f1;
    }

    public void setF1(double f1) {
        this.f1 = f1;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getQ() {
        return q;
    }

    public void setQ(double q) {
        this.q = q;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getSystemFocalLength() {
        return systemFocalLength;
    }

    public void setSystemFocalLength(double systemFocalLength) {
        this.systemFocalLength = systemFocalLength;
    }

    public double getMagnification() {
        return magnification;
    }

    public void setMagnification(double magnification) {
        this.magnification = magnification;
    }

    public double getCurvatureRadius2() {
        return curvatureRadius2;
    }

    public void setCurvatureRadius2(double curvatureRadius2) {
        this.curvatureRadius2 = curvatureRadius2;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getK1() {
        return k1;
    }

    public void setK1(double k1) {
        this.k1 = k1;
    }

    public double getK2() {
        return k2;
    }

    public void setK2(double k2) {
        this.k2 = k2;
    }

    public double getQp() {
        return qp;
    }

    public void setQp(double qp) {
        this.qp = qp;
    }

    public double getqR2() {
        return qR2;
    }

    public void setqR2(double qR2) {
        this.qR2 = qR2;
    }
}
