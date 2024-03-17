import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {
    @Test
    void startsWithDayOfWeek() {
        StringMethods instance = new StringMethods();
        assertTrue(instance.startsWithDayOfWeek("Monday"));
        assertTrue(instance.startsWithDayOfWeek("Tuesday"));
        assertTrue(instance.startsWithDayOfWeek("Monster"));
        assertTrue(instance.startsWithDayOfWeek("Wednesday"));
        assertTrue(instance.startsWithDayOfWeek("Thursday"));
        assertTrue(instance.startsWithDayOfWeek("Friday"));
        assertTrue(instance.startsWithDayOfWeek("Saturday"));
        assertTrue(instance.startsWithDayOfWeek("Sunday"));
        assertTrue(instance.startsWithDayOfWeek("Sunny"));
    }

    @Test
    void containsDayOfWeek() {
        StringMethods instance = new StringMethods();

        assertTrue(instance.containsDayOfWeek("Monday"));
        assertTrue(instance.containsDayOfWeek("Monkey"));
        assertTrue(instance.containsDayOfWeek("Dudemonkey"));
        assertTrue(instance.containsDayOfWeek("Dudetueskey"));
        assertTrue(instance.containsDayOfWeek("Dudwedskey"));
        assertTrue(instance.containsDayOfWeek("Dudwthurskey"));
        assertTrue(instance.containsDayOfWeek("Dufrihurskey"));
        assertTrue(instance.containsDayOfWeek("Dufsaturskey"));
        assertTrue(instance.containsDayOfWeek("Dufrihsuney"));
        assertFalse(instance.containsDayOfWeek("dude"));
    }

    @Test
    void removeVowels() {
        StringMethods instance = new StringMethods();

        String value = "xox";
        String expected = "xx";
        String actual = instance.removeVowelFromBetweenX(value);
        assertEquals(expected, actual);

        value = "onexexx";
        expected = "onexxx";
        actual = instance.removeVowelFromBetweenX(value);
        assertEquals(expected, actual);

        value = "xerrex";
        expected = "xerrex";
        actual = instance.removeVowelFromBetweenX(value);
        assertEquals(expected, actual);

        value = "xuxxuxxux";
        expected = "xxxxxx";
        actual = instance.removeVowelFromBetweenX(value);
        assertEquals(expected, actual);
    }
}