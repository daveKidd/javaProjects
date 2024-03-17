import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {

    @Test
    void removeZero() {
        ArrayMethods instance = new ArrayMethods();
        int[] values = {1,2,0,0,3,4,5,0,0,0,0,0,6,7,8,9};
        int[] expected = {1,2,3,4,5,6,7,8,9};
        int[] actual = instance.removeZero(values);
        assertArrayEquals(expected, actual);

        int[] values2 = {0,0,0,0,0};
        int[] expected2 = {};
        int[] actual2 = instance.removeZero(values2);
        assertArrayEquals(expected2, actual2);

        int[] values3 = {10,22,22,33};
        int[] expected3 = {10,22,22,33};
        int[] actual3 = instance.removeZero(values3);
        assertArrayEquals(expected3, actual3);
    }
}