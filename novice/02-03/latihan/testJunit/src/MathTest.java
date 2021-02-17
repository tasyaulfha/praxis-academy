import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {
    private Math math;
    @BeforeMethod
    public void setUp(){
        math = new Math();
    }
    @Test
    public void add_TwoPlusTwo_ReturnsFour() {
        final int expected = 4;
        final int actual = Math.add(2,2);
        Assert.assertEquals(actual,expected);
    }

    @Test
    void multiply() {
    }

    @Test
    public static double divide(int divident, int divisor) {
        if (divisor==0)
            throw new IllegalArgumentException("Cannot divide by zero(0)");
            return divident/divisor;

    }
    @Test
    public void divide_TenDivideedByFive_ReturnsTwo (){
        final double expected = 2.0;
        final double actual = Math.divide(10,5);
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void tearDown(){
        math=null;
    }

}