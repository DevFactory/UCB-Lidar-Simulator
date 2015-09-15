/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import atmosphere.functions.Function;
import atmosphere.functions.TestFunction;
import com.xeiam.xchart.Chart;
import java.awt.Color;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Internet
 */
public class IntegralSolverTest extends TestCase  {
    
    private IntegralSolver integralSolver;
    
   @Before
    public void setUp() {
        this.integralSolver = new IntegralSolver();
    }
    
    @Test
    public void testShouldIntegrateFunction(){
        TestFunction testFunction = new TestFunction();
        this.integralSolver.setFunction(testFunction);
        assertEquals(Math.log(Math.sqrt(8/3)),this.integralSolver.integration(2, 3));
    }
}
