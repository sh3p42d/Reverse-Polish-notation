package notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReversePolishNotationCalculatorTest {
    ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();

    @Test
    public void shouldCalculateAddition() {
        int calc = calculator.calculatePolishNotation("3 2 +");
        Assertions.assertEquals(5, calc);
    }

    @Test
    public void shouldCalculateSubtraction() {
        int calc = calculator.calculatePolishNotation("3 2 -");
        Assertions.assertEquals(1, calc);
    }

    @Test
    public void shouldCalculateMultiplication() {
        int calc = calculator.calculatePolishNotation("3 2 *");
        Assertions.assertEquals(6, calc);
    }

    @Test
    public void shouldCalculateAddSub() {
        int calc = calculator.calculatePolishNotation("3 2 1 + -");
        Assertions.assertEquals(0, calc);

        calc = calculator.calculatePolishNotation("3 2 1 - +");
        Assertions.assertEquals(4, calc);
    }

    @Test
    public void shouldCalculateAddMult() {
        int calc = calculator.calculatePolishNotation("3 2 1 + *");
        Assertions.assertEquals(9, calc);

        calc = calculator.calculatePolishNotation("3 2 1 * +");
        Assertions.assertEquals(5, calc);
    }

    @Test
    public void shouldCalculateSubMult() {
        int calc = calculator.calculatePolishNotation("3 2 1 - *");
        Assertions.assertEquals(3, calc);

        calc = calculator.calculatePolishNotation("3 2 1 * -");
        Assertions.assertEquals(1, calc);
    }

    @Test
    public void shouldCalculateAll() {
        int calc = calculator.calculatePolishNotation("4 3 2 1 + - *");
        Assertions.assertEquals(0, calc);

        calc = calculator.calculatePolishNotation("4 3 2 1 + * -");
        Assertions.assertEquals(-5, calc);

        calc = calculator.calculatePolishNotation("4 3 2 1 - + *");
        Assertions.assertEquals(16, calc);

        calc = calculator.calculatePolishNotation("4 3 2 1 * + -");
        Assertions.assertEquals(-1, calc);

        calc = calculator.calculatePolishNotation("4 3 2 1 - * +");
        Assertions.assertEquals(7, calc);

        calc = calculator.calculatePolishNotation("4 3 2 1 * - +");
        Assertions.assertEquals(5, calc);
    }

    @Test
    public void shouldCalculateWithExtraSpaces() {
        int calc = calculator.calculatePolishNotation("3 2  +");
        Assertions.assertEquals(5, calc);

        calc = calculator.calculatePolishNotation("3  2 +");
        Assertions.assertEquals(5, calc);

        calc = calculator.calculatePolishNotation(" 3 2 +");
        Assertions.assertEquals(5, calc);

        calc = calculator.calculatePolishNotation("3 2 + ");
        Assertions.assertEquals(5, calc);

        calc = calculator.calculatePolishNotation("  3  2  +  ");
        Assertions.assertEquals(5, calc);
    }

    @Test
    public void shouldCalculateWithNegative() {
        int calc = calculator.calculatePolishNotation("3 -1 +");
        Assertions.assertEquals(2, calc);

        calc = calculator.calculatePolishNotation("3 -1 -");
        Assertions.assertEquals(4, calc);

        calc = calculator.calculatePolishNotation("3 -1 *");
        Assertions.assertEquals(-3, calc);
    }
}