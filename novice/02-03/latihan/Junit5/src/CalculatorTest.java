import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

    class CalculatorTes{

    private Calculator calculator;

    @BeforeEach
     public void setUp() throws Exception {
        calculator = new Calculator();
        }
        @Test
        void exceptionTesting() {
            // set up user
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> user.setAge("23"));
            assertEquals("Age must be an Integer.", exception.getMessage());
        }

    @Test
    @DisplayName("Simple multiplication should work")
        public void testMultiply() {
        assertEquals(20, calculator.multiply(4,5),
        "Regular multiplication should work");
        assertEquals(calculator.multiply(4,5), 20, "Regular multiplication should work");
        Assertions.assertEquals("10 x 5 must be 50", 50, tester.multiply(10,5));
        }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
        public void testMultiplyWithZero() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));
        assertEquals(0, calculator.multiply(0,5), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(5,0), "Multiple with zero should be zero");
        }

}