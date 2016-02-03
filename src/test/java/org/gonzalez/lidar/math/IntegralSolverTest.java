/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gonzalez.lidar.math;

import org.gonzalez.lidar.atmosphere.functions.PowFunction;
import org.gonzalez.lidar.atmosphere.functions.TestFunction;
import org.gonzalez.lidar.helpers.IntegralSolver;
import junit.framework.TestCase;
import org.junit.Before;

import java.text.DecimalFormat;

public class IntegralSolverTest extends TestCase {

    private IntegralSolver integralSolver;
    private DecimalFormat decimalFormat;

    @Before
    public void setUp() {
        this.integralSolver = new IntegralSolver();
        this.decimalFormat = new DecimalFormat("#.00");
    }

    public void testShouldIntegrateFunctionWithPositiveRange() {

        PowFunction powFunction = new PowFunction();
        this.integralSolver.setFunction(powFunction);
        assertEquals(this.decimalFormat.format(41.66666), this.decimalFormat.format(this.integralSolver.integration(0, 5)));
    }

    public void testShouldIntegrateFunctionWithNegativeRange() {
        TestFunction testFunction = new TestFunction();
        this.integralSolver.setFunction(testFunction);
        assertEquals(this.decimalFormat.format(-5.0 / 72.0), this.decimalFormat.format(this.integralSolver.integration(-2, -1)));
    }
}
