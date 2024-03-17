import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise06Test {

    Exercise06 instance = new Exercise06();

    // Suggested test additions:
    // shouldBeNullForNulLArg
    // shouldCapitalizeMultipleElements (several scenarios)
    // shouldIgnoreNullElements
    // shouldIgnoreEmptyElements

    @Test
    void shouldCapitalizeOneElement() {
        String[] values = {"lower"};
        String[] expected = {"Lower"};
        String[] actual = instance.capitalizeAll(values);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCapitalizeMultipleElements() {
        String[] values = {"lower","higher","smaller","bigger"};
        String[] expected = {"Lower","Higher","Smaller","Bigger"};
        String[] actual = instance.capitalizeAll(values);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldBeEmptyForEmptyArg() {
        assertArrayEquals(new String[0], instance.capitalizeAll(new String[0]));
    }

    @Test
    void shouldIgnoreNullElements(){
        String[] values = {"lower",null,"smaller",null};
        String[] expected = {"Lower",null,"Smaller",null};
        String[] actual = instance.capitalizeAll(values);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldIgnoreEmptyElements(){
        String[] values = {"lower","","smaller",""};
        String[] expected = {"Lower","","Smaller",""};
        String[] actual = instance.capitalizeAll(values);
        assertArrayEquals(expected, actual);
    }
}