package laser;

public class Laser {

    private double emissionWavelength;
    private double energy;
    private double PRF;
    private double beamWidth;
    private double divergence;

    public Laser() {
        this.emissionWavelength = 532;
        this.divergence = 0.5e-3;

    }

    public Laser(int emissionWavelength, double energy, double PRF, double beamWidth, double divergence) {
        this.emissionWavelength = emissionWavelength;
        this.energy = energy;
        this.PRF = PRF;
        this.beamWidth = beamWidth;
        this.divergence = divergence;
    }

    public double getEmissionWavelength() {
        return emissionWavelength;
    }

    public void setEmissionWavelength(double emissionWavelength) {
        this.emissionWavelength = emissionWavelength;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getPRF() {
        return PRF;
    }

    public void setPRF(double PRF) {
        this.PRF = PRF;
    }

    public double getBeamWidth() {
        return beamWidth;
    }

    public void setBeamWidth(double beamWidth) {
        this.beamWidth = beamWidth;
    }

    public double getDivergence() {
        return divergence;
    }

    public void setDivergence(double divergence) {
        this.divergence = divergence;
    }
}
