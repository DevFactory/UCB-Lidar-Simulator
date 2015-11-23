package linkbudget;

import junit.framework.TestCase;
import laser.Laser;
import monochromator.Monochromator;
import telescope.Telescope;

import java.util.ArrayList;

public class LinkBudgetTest extends TestCase {

    private LinkBudget linkBudget;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        this.linkBudget = new LinkBudget();
    }

    public void testShouldReturnCorrectName() throws Exception {
        assertEquals("SNR", this.linkBudget.getName());
    }

    public void testShouldSetAndReturnLValue() throws Exception {
        this.linkBudget.setL(0.34);
        assertEquals(0.34, this.linkBudget.getL());
    }

    public void testShouldSetAndReturnKValue() throws Exception {
        this.linkBudget.setK(0.121e-34);
        assertEquals(0.121e-34, this.linkBudget.getK());
    }

    public void testShouldSetAndReturnCValue() throws Exception {
        assertEquals(2.99793E8, this.linkBudget.getC());
        this.linkBudget.setC(1.243e2);
        assertEquals(1.243e2, this.linkBudget.getC());
    }

    public void testShouldSetAndGetArValue() throws Exception {
        this.linkBudget.setAr(12.90);
        assertEquals(12.90, this.linkBudget.getAr());
    }
}
