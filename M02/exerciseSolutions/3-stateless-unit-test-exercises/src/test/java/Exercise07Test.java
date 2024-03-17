import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise07Test {
    Exercise07 instance = new Exercise07();

    @Test
    void shouldReverseArray() {
        String[] values = {"lower","higher","smaller","bigger"};
        String[] expected = {"bigger","smaller","higher","lower"};
        String[] actual = instance.reverse(values);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotChangeOriginalArray() {
        String[] values = {"lower","higher","smaller","bigger"};
        String[] expected = {"lower","higher","smaller","bigger"};;
        instance.reverse(values);
        assertArrayEquals(values, expected);
    }
}