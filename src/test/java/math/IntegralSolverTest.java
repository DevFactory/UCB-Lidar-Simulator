/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import atmosphere.functions.PowFunction;
import atmosphere.functions.TestFunction;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 * @author Internet
 */
public class IntegralSolverTest extends TestCase {

    private IntegralSolver integralSolver;
    private DecimalFormat decimalFormat;

    @Before
    public void setUp() {
        this.integralSolver = new IntegralSolver();
        this.decimalFormat = new DecimalFormat("#.00");
    }

    @Test
    public void testShouldIntegrateFunctionWithPositiveRange() {

        PowFunction powFunction = new PowFunction();
        this.integralSolver.setFunction(powFunction);
        assertEquals(this.decimalFormat.format(41.66666), this.decimalFormat.format(this.integralSolver.integration(0, 5)));
    }

    @Test
    public void testShouldIntegrateFunctionWithNegativeRange() {
        TestFunction testFunction = new TestFunction();
        this.integralSolver.setFunction(testFunction);
        assertEquals(this.decimalFormat.format(-5.0 / 72.0), this.decimalFormat.format(this.integralSolver.integration(-2, -1)));
    }
}
