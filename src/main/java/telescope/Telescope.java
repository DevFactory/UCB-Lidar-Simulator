package telescope;

/**
 * Created by Oscar on 6/30/15.
 */
public class Telescope {
    private double shadeDiameter;
    private double focalLength;
    private double Transmissivity;
    private double diameter;

    public Telescope() {
        this.shadeDiameter = 0.06858;
        this.diameter = 0.2032;
        this.focalLength = 2;
    }

    public Telescope(double shadeDiameter, double focalLength, double transmissivity, double diameter) {
        this.shadeDiameter = shadeDiameter;
        this.focalLength = focalLength;
        this.Transmissivity = transmissivity;
        this.diameter = diameter;
    }

    public double getShadeDiameter() {
        return shadeDiameter;
    }

    public void setShadeDiameter(double shadeDiameter) {
        this.shadeDiameter = shadeDiameter;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }

    public double getTransmissivity() {
        return Transmissivity;
    }

    public void setTransmissivity(double transmissivity) {
        this.Transmissivity = transmissivity;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}
