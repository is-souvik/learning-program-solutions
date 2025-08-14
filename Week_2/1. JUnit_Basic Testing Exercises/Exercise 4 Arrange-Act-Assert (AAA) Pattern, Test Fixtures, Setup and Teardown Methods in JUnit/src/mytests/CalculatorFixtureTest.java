package mytests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorFixtureTest {

    private Calculator calc;

    @Before
    public void setUp() {
        // Arrange
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        calc = null; // cleanup after each test
    }

    @Test
    public void testAdd() {
        // Act
        int result = calc.add(2, 3);
        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        // Act
        int result = calc.subtract(5, 2);
        // Assert
        assertEquals(3, result);
    }
}
