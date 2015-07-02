import junit.framework.TestCase;

/**
 * Created by Oscar on 7/1/15.
 */
public class FakeTest extends TestCase {
    public  void testSum() {
        int expected = 3;
        int sum = 1 + 2;

        assertEquals(expected, sum);
    }
}
