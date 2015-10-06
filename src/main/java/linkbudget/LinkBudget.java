package linkbudget;

/**
 * Created by Oscar on 9/30/15.
 */
public class LinkBudget {

    public double noise;
    public double photoInducedShotNoise;
    public double darkShotNoise;
    public double thermalNoise;
    public double spatialResolution;
    public double temporalResolution;
    public double signalToNoiseRatio;

    public LinkBudget() {

    }

    public void signalConditioning() {

    }

    public void calculateSignalToNoiseRatio(double R, double L, double Pr, double B) {
        this.signalToNoiseRatio = (R * L * Pr) / (Math.sqrt(this.noise) * Math.pow(B, 0.5));
    }

    public void totalNoise() {
        this.noise = this.photoInducedShotNoise + this.darkShotNoise + this.thermalNoise;
    }

    public void calculateSpatialResolution(double c, double fs) {
        this.spatialResolution = c / 2 * fs;
    }

    public void calculateTemporalResolution(double ni, double P, double R, double F) {
        this.temporalResolution = ni * P * R * F;
    }

    public void calculatePhotoInducedShotNoise(double q, double G, double F, double M, double R, double Pr, double Pb, double L) {
        this.photoInducedShotNoise = 2 * q * Math.pow(G, 2) * F * Math.pow(M, 2) * R * (Pr + Pb) * L;
    }

    public void calculateDarkShotNoise(double q, double G, double Ids, double F, double M, double Idb) {
        this.darkShotNoise = 2 * q * Math.pow(G, 2) * (Ids + F * Math.pow(M, 2) * Idb);
    }

    public void calculateThermalNoise(double gama, double G) {
        this.thermalNoise = gama * Math.pow(G, 2);
    }
}
