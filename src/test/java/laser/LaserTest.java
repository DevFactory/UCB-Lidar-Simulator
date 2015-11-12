package laser;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class LaserTest extends TestCase {
    private Laser laser = new Laser();
    private double expected;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.laser.setEnergy(871);
        this.laser.setPRF(6776.22);
        this.laser.setBeamWidth(243);
    }


    @Test
    public void testShouldObtainDefaultEmissionWaveLength() throws Exception {
        this.expected = 532;
        assertEquals(expected, this.laser.getEmissionWavelength());
    }

    @Test
    public void testShouldSetEmissionWaveLenght() {
        this.expected = 8778.23;
        this.laser.setEmissionWavelength(8778.23);
        assertEquals(this.expected, this.laser.getEmissionWavelength());
    }

    @Test
    public void testShouldObtainDefaultDivergence() {
        this.expected = 0.5e-3;
        assertEquals(this.expected, this.laser.getDivergence());
    }

    @Test
    public void testShouldSetDivergence() {
        this.expected = 0.56e-24;
        this.laser.setDivergence(0.56e-24);
        assertEquals(this.expected, this.laser.getDivergence());
    }

    @Test
    public void testShouldObtainCorrectEnergy() {
        this.expected = 871;
        assertEquals(this.expected, this.laser.getEnergy());
    }

    @Test
    public void testShouldSetEnergy() {
        this.laser.setEnergy(562);
        this.expected = 562;
        assertEquals(this.expected, this.laser.getEnergy());
    }

    @Test
    public void testShouldObtainCorrectPRF() {
        this.expected = 6776.22;
        assertEquals(this.expected, this.laser.getPRF());
    }

    @Test
    public void testShouldSetPRF() {
        this.laser.setPRF(1243.232);
        this.expected = 1243.232;
        assertEquals(this.expected, this.laser.getPRF());
    }

    @Test
    public void testShouldObtainCorrectBeamWidth() {
        this.expected = 243;
        assertEquals(this.expected, this.laser.getBeamWidth());
    }

    @Test
    public void testShouldSetBeamWidth() {
        this.laser.setBeamWidth(2144);
        this.expected = 2144;
        assertEquals(this.expected, this.laser.getBeamWidth());
    }

    @Test
    public void testShouldCreateAnObjectFromLaserClass() {
        this.laser = new Laser(543, 0.5e-3, 7868.54, 232.23, 983.98);
        assertEquals(543.0, this.laser.getEmissionWavelength());
        assertEquals(0.5e-3, this.laser.getEnergy());
        assertEquals(7868.54, this.laser.getPRF());
        assertEquals(232.23, this.laser.getBeamWidth());
        assertEquals(983.98, this.laser.getDivergence());
    }
}
