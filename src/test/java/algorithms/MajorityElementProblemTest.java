package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MajorityElementProblemTest {

    private final MajorityElementProblem solver = new MajorityElementProblem();

    @Test
    void testMajorityExists() {
        int[] nums = {2, 2, 1, 2, 3, 2, 2};
        assertEquals(2, solver.solution(nums));
    }

    @Test
    void testMajoritySingleElement() {
        int[] nums = {7};
        assertEquals(7, solver.solution(nums));
    }

    @Test
    void testMajorityAllSame() {
        int[] nums = {5, 5, 5, 5, 5};
        assertEquals(5, solver.solution(nums));
    }

    @Test
    void testNoMajority() {
        int[] nums = {1, 2, 3, 4};
        assertEquals(-1, solver.solution(nums));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertThrows(IllegalArgumentException.class, () -> solver.solution(nums));
    }

    @Test
    void testMajorityAtEnd() {
        int[] nums = {1, 2, 3, 2, 2, 2, 2};
        assertEquals(2, solver.solution(nums));
    }

    @Test
    void testMajorityAtBeginning() {
        int[] nums = {9, 9, 9, 2, 3, 4};
        assertEquals(-1, solver.solution(nums));
    }

    @Test
    void testMajorityNegativeNumbers() {
        int[] nums = {-1, -1, -1, 2, 3};
        assertEquals(-1, solver.solution(nums));
    }

    @Test
    void testMajorityWithZeros() {
        int[] nums = {0, 0, 0, 1, 2, 0};
        assertEquals(0, solver.solution(nums));
    }
}
