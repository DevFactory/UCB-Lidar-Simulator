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
        this.telescope.setTransmissivity(8778.82);
    }

    @Test
    public void testShouldGetDefaultShadeDiameter() {
        this.expected = 0.06858;
        assertEquals(this.expected, this.telescope.getShadeDiameter());
    }

    @Test
    public void testShouldSetShadeDiameter() {
        this.telescope.setShadeDiameter(0.03432);
        this.expected = 0.03432;
        assertEquals(this.expected, this.telescope.getShadeDiameter());
    }

    @Test
    public void testShouldGetDefaultDiameter() {
        this.expected = 0.2032;
        assertEquals(this.expected, this.telescope.getDiameter());
    }

    @Test
    public void testShouldSetDiameter() {
        this.telescope.setDiameter(0.4563);
        this.expected = 0.4563;
        assertEquals(this.expected, this.telescope.getDiameter());
    }

    @Test
    public void testShouldGetDefaultFocalLength() {
        this.expected = 2;
        assertEquals(this.expected, this.telescope.getFocalLength());
    }

    @Test
    public void testShouldSetFocalLength() {
        this.telescope.setFocalLength(4);
        this.expected = 4;
        assertEquals(this.expected, this.telescope.getFocalLength());
    }

    @Test
    public void testShouldGetTransmissivity() {
        this.expected = 8778.82;
        assertEquals(this.expected, this.telescope.getTransmissivity());
    }

    @Test
    public void testShouldSetTransmissivity() {
        this.telescope.setTransmissivity(1782.73);
        this.expected = 1782.73;
        assertEquals(this.expected, this.telescope.getTransmissivity());
    }

    @Test
    public void testShouldCreateAnObjectFromTelescopeClass() {
        this.telescope = new Telescope(543, 0.5e-3, 7868.54, 232.23);
        assertEquals(543.0, this.telescope.getShadeDiameter());
        assertEquals(0.5e-3, this.telescope.getFocalLength());
        assertEquals(7868.54, this.telescope.getTransmissivity());
        assertEquals(232.23, this.telescope.getDiameter());
    }

}
