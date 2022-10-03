import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerfectNumber {

    @Test
    public void isPerfect_6() {
        assertTrue(PerfectNumber.isPerfectNumber(6));
    }

    @Test
    public void isPerfect_9() {
        assertFalse(PerfectNumber.isPerfectNumber(9));
    }

    @Test
    public void isPerfect_5() {
        assertFalse(PerfectNumber.isPerfectNumber(5));
    }

    @Test
    public void isPerfect_60() {
        assertFalse(PerfectNumber.isPerfectNumber(60));
    }

    @Test
    public void isPerfect_28() {
        assertTrue(PerfectNumber.isPerfectNumber(28));
    }

    @Test
    public void isPerfect_496() {
        assertTrue(PerfectNumber.isPerfectNumber(496));
    }

    @Test
    public void isPerfect_500() {
        assertFalse(PerfectNumber.isPerfectNumber(500));
    }

    @Test
    public void isPerfect_8128() {
        assertTrue(PerfectNumber.isPerfectNumber(8128));
    }

    @Test
    public void isPerfect_33550336() {
        assertTrue(PerfectNumber.isPerfectNumber(33550336));
    }

    @Test
    public void sumOfDivisors_6() {
        assertEquals(6, PerfectNumber.sumOfDivisors(6));
    }

    @Test
    public void sumOfDivisors_9() {
        assertEquals(4, PerfectNumber.sumOfDivisors(9));
    }

    @Test
    public void sumOfDivisors_5() {
        assertEquals(1, PerfectNumber.sumOfDivisors(5));
    }

    @Test
    public void sumOfDivisors_60() {
        assertEquals(108, PerfectNumber.sumOfDivisors(60));
    }

    @Test
    public void sumOfDivisors_28() {
        assertEquals(28, PerfectNumber.sumOfDivisors(28));
    }

    @Test
    public void sumOfDivisors_496() {
        assertEquals(496, PerfectNumber.sumOfDivisors(496));
    }

    @Test
    public void sumOfDivisors_500() {
        assertEquals(592, PerfectNumber.sumOfDivisors(500));
    }

    @Test
    public void sumOfDivisors_8128() {
        assertEquals(8128, PerfectNumber.sumOfDivisors(8128));
    }

    @Test
    public void sumOfDivisors_33550336() {
        assertEquals(33550336, PerfectNumber.sumOfDivisors(33550336));
    }
}
