package llm;

import app.Calc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcLLMTest {

    private final Calc calc = new Calc();

    @Test
    void add_basicCases() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(0, calc.add(0, 0));
        assertEquals(-1, calc.add(2, -3));
    }

    @Test
    void div_basicAndException() {
        assertEquals(2, calc.div(10, 5));
        assertEquals(-2, calc.div(10, -5));
        assertThrows(IllegalArgumentException.class, () -> calc.div(1, 0));
    }

    @Test
    void clamp_allBranches() {
        assertEquals(5, calc.clamp(5, 0, 10));
        assertEquals(0, calc.clamp(-1, 0, 10));
        assertEquals(10, calc.clamp(999, 0, 10));
        assertThrows(IllegalArgumentException.class, () -> calc.clamp(1, 10, 0));
    }

    @Test
    void parseIntOrDefault_edges() {
        assertEquals(7, calc.parseIntOrDefault("7", 0));
        assertEquals(-7, calc.parseIntOrDefault("-7", 0));
        assertEquals(7, calc.parseIntOrDefault("   7   ", 0));
        assertEquals(0, calc.parseIntOrDefault(null, 0));
        assertEquals(9, calc.parseIntOrDefault("", 9));
        assertEquals(9, calc.parseIntOrDefault("   ", 9));
        assertEquals(9, calc.parseIntOrDefault("-", 9));
        assertEquals(9, calc.parseIntOrDefault("12a", 9));
    }
}
