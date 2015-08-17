package telescope;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Oscar on 7/2/15.
 */
public class TelescopeTest extends TestCase {

    private Telescope telescope = new Telescope();
    private double expected;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        telescope.setSystemFocalLength(12.5);
        telescope.setCurvatureRadius2(47.35);
        telescope.setP(15.72);
    }

    @Test
    public void testComputeSystemFocalLength() throws Exception {
        this.telescope.setF1(0.5689);
        this.telescope.setMagnification(50.0);
        expected = this.telescope.getF1() * this.telescope.getMagnification();
        this.telescope.computeSystemFocalLength();
        assertEquals(expected, this.telescope.getSystemFocalLength());

    }

    @Test
    public void testComputeSystemMagnification() throws Exception {
        this.telescope.computeQ();
        expected = this.telescope.getQ() / this.telescope.getP();
        this.telescope.computeSystemMagnification();
        assertEquals(expected, this.telescope.getMagnification());
    }

    @Test
    public void testComputeP() throws Exception {
        this.telescope.setF1(2.75);
        this.telescope.setMagnification(24.9);
        this.telescope.setE(12.67);
        this.telescope.computeP();
        expected = (this.telescope.getF1() + this.telescope.getE()) / (this.telescope.getMagnification() + 1);
        assertEquals(expected, this.telescope.getP());
    }

    @Test
    public void testComputeR2() throws Exception {
        this.telescope.setP(15.72);
        this.telescope.setMagnification(17.9);
        expected = 33.3003550295858;
        this.telescope.computeR2();
        assertEquals(expected, this.telescope.getCurvatureRadius2());
    }

    @Test
    public void testComputeD2() throws Exception {
        this.telescope.setD1(7.0);
        this.telescope.setP(15.72);
        this.telescope.setF1(2.75);
        this.telescope.computeD2();
        expected = 40.014545454545456;
        assertEquals(expected, this.telescope.getD2());
    }

    @Test
    public void testComputeS() throws Exception {
        this.telescope.setQ(8.0);
        this.telescope.setD(9.76);
        this.telescope.computeS();
        expected = 0.819672131147541;
        assertEquals(expected, this.telescope.getS());
    }

    @Test
    public void testComputeK2() throws Exception {
        this.telescope.setMagnification(29.67);
        this.telescope.computeK2();
        expected = -1.1443850247862175;
        assertEquals(expected, this.telescope.getK2());

    }

    @Test
    public void testComputeQP() throws Exception {
        this.telescope.computeQP();
        expected = 8.857264365354945;
        assertEquals(expected, this.telescope.getQp());
    }

    @Test
    public void testComputeQR2() throws Exception {
        this.telescope.computeQR2();
        expected = -1.9525165321432114;
        assertEquals(expected, this.telescope.getqR2());

    }

    @Test
    public void testComputeQ() throws Exception {
        this.telescope.computeQ();
        assertEquals(46.7845380263985, this.telescope.getQ());

    }
}
