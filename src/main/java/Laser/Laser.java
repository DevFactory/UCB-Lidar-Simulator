package laser;

public class Laser {

    private double outputWaveLength;//nm
    private double outputEnergyPerPulse;// uJ
    private double repetitionRate;//kHz
    private double pulseDuration; //ns
    private double effectiveAperture; //cm^2
    private double FOV; //urad
    private double filterBandwidth;//nm
    private double acquisitionTime;//s
    private double verticalResolution;//m


    public Laser() {
        this.outputWaveLength = 532.0;
        this.outputEnergyPerPulse = 4.0;
        this.repetitionRate = 5.0;
        this.pulseDuration = 0.99;
        this.effectiveAperture = 314.0;
        this.FOV = 55.0;
        this.filterBandwidth = 0.5;
        this.acquisitionTime = 0.8;
        this.verticalResolution = 15.0;
    }

    public Laser(double outputWaveLength, double outputEnergyPerPulse, double repetitionRate, double pulseDuration, double effectiveAperture, double FOV, double filterBandwidth, double acquisitionTime, double verticalResolution) {
        this.outputWaveLength = outputWaveLength;
        this.outputEnergyPerPulse = outputEnergyPerPulse;
        this.repetitionRate = repetitionRate;
        this.pulseDuration = pulseDuration;
        this.effectiveAperture = effectiveAperture;
        this.FOV = FOV;
        this.filterBandwidth = filterBandwidth;
        this.acquisitionTime = acquisitionTime;
        this.verticalResolution = verticalResolution;
    }

    public double getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(double acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public double getVerticalResolution() {
        return verticalResolution;
    }

    public void setVerticalResolution(double verticalResolution) {
        this.verticalResolution = verticalResolution;
    }

    public double getOutputWaveLength() {
        return outputWaveLength;
    }

    public void setOutputWaveLength(double outputWaveLength) {
        this.outputWaveLength = outputWaveLength;
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
