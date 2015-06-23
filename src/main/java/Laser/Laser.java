package Laser;

/**
 * Created by Oscar on 6/23/15.
 */
public class Laser {

    private double outputWaveLenght;//nm
    private double outputEnergyPerPulse;// uJ
    private double repetitionRate;//kHz
    private double pulseDuration; //ns
    private double effectiveAperture; //cm^2
    private double FOV; //urad
    private double filterBandwidth;//nm

    public Laser() {
        this.outputWaveLenght = 532.0;
        this.outputEnergyPerPulse = 4.0;
        this.repetitionRate = 5.0;
        this.pulseDuration = 0.99;
        this.effectiveAperture = 314.0;
        this.FOV = 55.0;
        this.filterBandwidth = 0.5;
    }

    public Laser(double outputWaveLenght, double outputEnergyPerPulse, double repetitionRate, double pulseDuration, double effectiveAperture, double FOV, double filterBandwidth) {
        this.outputWaveLenght = outputWaveLenght;
        this.outputEnergyPerPulse = outputEnergyPerPulse;
        this.repetitionRate = repetitionRate;
        this.pulseDuration = pulseDuration;
        this.effectiveAperture = effectiveAperture;
        this.FOV = FOV;
        this.filterBandwidth = filterBandwidth;
    }

    public double getOutputWaveLenght() {
        return outputWaveLenght;
    }

    public void setOutputWaveLenght(double outputWaveLenght) {
        this.outputWaveLenght = outputWaveLenght;
    }

    public double getOutputEnergyPerPulse() {
        return outputEnergyPerPulse;
    }

    public void setOutputEnergyPerPulse(double outputEnergyPerPulse) {
        this.outputEnergyPerPulse = outputEnergyPerPulse;
    }

    public double getRepetitionRate() {
        return repetitionRate;
    }

    public void setRepetitionRate(double repetitionRate) {
        this.repetitionRate = repetitionRate;
    }

    public double getPulseDuration() {
        return pulseDuration;
    }

    public void setPulseDuration(double pulseDuration) {
        this.pulseDuration = pulseDuration;
    }

    public double getEffectiveAperture() {
        return effectiveAperture;
    }

    public void setEffectiveAperture(double effectiveAperture) {
        this.effectiveAperture = effectiveAperture;
    }

    public double getFOV() {
        return FOV;
    }

    public void setFOV(double FOV) {
        this.FOV = FOV;
    }

    public double getFilterBandwidth() {
        return filterBandwidth;
    }

    public void setFilterBandwidth(double filterBandwidth) {
        this.filterBandwidth = filterBandwidth;
    }
}
