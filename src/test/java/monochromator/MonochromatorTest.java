package monochromator;

import junit.framework.TestCase;
import org.junit.Test;

public class MonochromatorTest extends TestCase {

    private Monochromator monochromator = new Monochromator();

    @Test
    public void testShouldGetAndSetMultiplicationFactor() {
        this.monochromator.setM(0.9283);
        assertEquals(0.9283, this.monochromator.getM());
    }

    @Test
    public void testShouldGetAndSetExcessNoiseFactor() {
        this.monochromator.setF(289.72);
        assertEquals(289.72, this.monochromator.getF());
    }

    @Test
    public void testShouldGetAndSetSurfaceDarkCurrent() {
        this.monochromator.setIds(783.920);
        assertEquals(783.920, this.monochromator.getIds());
    }

    @Test
    public void testShouldGetAndSetCathodeSensitivity() {
        this.monochromator.setRio(0.382);
        assertEquals(0.382, this.monochromator.getRio());
    }

    @Test
    public void testShouldGetAndSetAnodeDarkCurrent() {
        this.monochromator.setIda(1.82);
        assertEquals(1.82, this.monochromator.getIda());
    }

    @Test
    public void testShouldGetAndSetBulkDarkCurrent() {
        this.monochromator.setIdb(8.3e12);
        assertEquals(8.3e12, this.monochromator.getIdb());
    }

    @Test
    public void testShouldGetAndSetTransducerGain() {
        this.monochromator.setR(1.3e-12);
        assertEquals(1.3e-12, this.monochromator.getR());
    }

    @Test
    public void testShouldGetAndSetGT() {
        this.monochromator.setGT(0.0002389232);
        assertEquals(0.0002389232, this.monochromator.getGT());
    }

    @Test
    public void testShouldGetAndSetNv() {
        this.monochromator.setNv(12.837);
        assertEquals(12.837, this.monochromator.getNv());
    }

    @Test
    public void testShouldGetAndSetCurrentNoiseDensity() {
        this.monochromator.setSigampA(1.23e-5);
        assertEquals(1.23e-5, this.monochromator.getSigampA());
    }

    @Test
    public void testShouldGetAndSetPreamplifierLimits() {
        this.monochromator.setB(127.0);
        assertEquals(127.0, this.monochromator.getB());
    }

    @Test
    public void testShouldGetDefaultKValue() {
        assertEquals(1.38e-23, this.monochromator.getK());
    }

    @Test
    public void testShouldGetAndSetBoltzmannConstant() {
        this.monochromator.setK(1.127e21);
        assertEquals(1.127e21, this.monochromator.getK());
    }

    @Test
    public void testShouldGetDefaultOverlapFactorValue() {
        assertEquals(1.0, this.monochromator.getOverlapFactor());
    }

    @Test
    public void testShouldGetAndSetOverlapFactor() {
        this.monochromator.setOverlapFactor(123.25);
        assertEquals(123.25, this.monochromator.getOverlapFactor());
    }
}
