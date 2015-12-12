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

    public void testShouldGetAndSetdFiberValue() {
        this.linkBudget.setdFiber(12.90e-34);
        assertEquals(12.90e-34, this.linkBudget.getdFiber());
    }

    public void testShouldGetAndSetFOV() {
        this.linkBudget.setFov(12.98);
        assertEquals(12.98, this.linkBudget.getFov());
    }

    public void testShouldGetAndSetdOmega() {
        this.linkBudget.setdOmega(123.90);
        assertEquals(123.90, this.linkBudget.getdOmega());
    }

    public void testShouldGetAndSetrMin() {
        this.linkBudget.setrMin(0.034);
        assertEquals(0.034, this.linkBudget.getrMin());
    }

    public void testShouldgetAndSetrMax() {
        this.linkBudget.setrMax(0.034);
        assertEquals(0.034, this.linkBudget.getrMax());
    }

    public void testShouldGetAndSetrPBL() {
        this.linkBudget.setrPBL(140.23);
        assertEquals(140.23, this.linkBudget.getrPBL());
    }

    public void testShouldGetAndSetdLambda0() {
        this.linkBudget.setdLambda0(12.3e-45);
        assertEquals(12.3e-45, this.linkBudget.getdLambda0());
    }

    public void testShouldgetAndSetB() {
        this.linkBudget.setB(12.90);
        assertEquals(12.90, this.linkBudget.getB());
    }

    public void testShouldGetDefaultqAndThenSetItAndGetIt() {
        assertEquals(1.602e-19, this.linkBudget.getQ());
        this.linkBudget.setQ(1.89e-34);
        assertEquals(1.89e-34, this.linkBudget.getQ());
    }

    public void testShouldSetAndGetNsamples() {
        this.linkBudget.setnSamples(12.0);
        assertEquals(12.0, this.linkBudget.getnSamples());
    }

    public void testShouldSetAndGetOvf() {
        this.linkBudget.setOvf(12.98);
        assertEquals(12.98, this.linkBudget.getOvf());
    }

    public void testShoulSetAndGetPowb0() {
        this.linkBudget.setPowb0(1.43e-4);
        assertEquals(1.43e-4, this.linkBudget.getPowb0());
    }

    public void testShouldSetAndGetRi() {
        this.linkBudget.setRi(12.90);
        assertEquals(12.90, this.linkBudget.getRi());
    }

}
