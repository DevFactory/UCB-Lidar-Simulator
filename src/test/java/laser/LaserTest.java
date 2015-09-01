package laser;

import junit.framework.TestCase;
import org.junit.Test;

public class LaserTest extends TestCase {

    private Laser laser = new Laser();
    private double expected;


    @Test
    public void testGetAcquisitionTime() throws Exception {
        expected = 0.8;
        assertEquals(expected, this.laser.getAcquisitionTime());
    }

    @Test
    public void testSetAcquisitionTime() throws Exception {
        this.laser.setAcquisitionTime(11.7);
        expected = 11.7;
        assertEquals(expected, this.laser.getAcquisitionTime());
    }

    @Test
    public void testGetVerticalResolution() throws Exception {
        expected = 15.0;
        assertEquals(expected, this.laser.getVerticalResolution());
    }

    @Test
    public void testSetVerticalResolution() throws Exception {
        this.laser.setVerticalResolution(11.7);
        expected = 11.7;
        assertEquals(expected, this.laser.getVerticalResolution());
    }

    @Test
    public void testGetOutputWaveLength() throws Exception {
        expected = 532.0;
        assertEquals(expected, this.laser.getOutputWaveLength());
    }

    @Test
    public void testSetOutputWaveLength() throws Exception {
        this.laser.setOutputWaveLength(1064.0);
        expected = 1064.0;
        assertEquals(expected, this.laser.getOutputWaveLength());
    }

    @Test
    public void testGetOutputEnergyPerPulse() throws Exception {
        expected = 4.0;
        assertEquals(expected, this.laser.getOutputEnergyPerPulse());
    }

    @Test
    public void testSetOutputEnergyPerPulse() throws Exception {
        this.laser.setOutputEnergyPerPulse(12.0);
        expected = 12.0;
        assertEquals(expected, this.laser.getOutputEnergyPerPulse());

    }

    @Test
    public void testGetRepetitionRate() throws Exception {
        expected = 5.0;
        assertEquals(expected, this.laser.getRepetitionRate());
    }

    @Test
    public void testSetRepetitionRate() throws Exception {
        this.laser.setRepetitionRate(12.0);
        expected = 12.0;
        assertEquals(expected, this.laser.getRepetitionRate());
    }

    @Test
    public void testGetPulseDuration() throws Exception {
        expected = 0.99;
        assertEquals(expected, this.laser.getPulseDuration());
    }

    @Test
    public void testSetPulseDuration() throws Exception {
        this.laser.setPulseDuration(0.75);
        expected = 0.75;
        assertEquals(expected, this.laser.getPulseDuration());
    }

    @Test
    public void testGetEffectiveAperture() throws Exception {
        expected = 314.0;
        assertEquals(expected, this.laser.getEffectiveAperture());
    }

    @Test
    public void testSetEffectiveAperture() throws Exception {
        this.laser.setEffectiveAperture(129.87);
        expected = 129.87;
        assertEquals(expected, this.laser.getEffectiveAperture());
    }

    @Test
    public void testGetFOV() throws Exception {
        expected = 55.0;
        assertEquals(expected, this.laser.getFOV());

    }

    @Test
    public void testSetFOV() throws Exception {
        this.laser.setFOV(76.56);
        expected = 76.56;
        assertEquals(expected, this.laser.getFOV());

    }

    @Test
    public void testGetFilterBandwidth() throws Exception {
        expected = 0.5;
        assertEquals(expected, this.laser.getFilterBandwidth());
    }

    @Test
    public void testSetFilterBandwidth() throws Exception {
        this.laser.setFilterBandwidth(0.33);
        expected = 0.33;
        assertEquals(expected, this.laser.getFilterBandwidth());

    }
}
