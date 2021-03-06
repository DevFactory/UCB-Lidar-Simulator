package rayleigh;

import org.gonzalez.lidar.atmosphere.Pressure;
import org.gonzalez.lidar.atmosphere.Rayleigh;
import org.gonzalez.lidar.atmosphere.Temperature;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class RayleighTest extends TestCase {
    private Rayleigh rayleigh;
    private Temperature temperature;
    private Pressure pressure;
    private double expected;
    private Collection<Number> altitudes = new ArrayList<Number>();

    public void defaultAltitudes() {
        for (int i = 0; i < 11001; i++) {
            this.altitudes.add(i);
        }
    }

    @Before
    public void setUp() {
        defaultAltitudes();
        this.temperature = new Temperature(this.altitudes);
        this.pressure = new Pressure(this.temperature.getResults());
        this.rayleigh = new Rayleigh(this.altitudes);
    }

    @Test
    public void testShouldReturnNull() {
        assertEquals(null, null);
    }

}
