import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise03Test {

    @Test
    void hasAllVowels() {
        assertTrue(Exercise03.hasAllVowels("aeiou"));
        assertTrue(Exercise03.hasAllVowels("AEIOU"));
        assertTrue(Exercise03.hasAllVowels("AeIoU"));
        assertTrue(Exercise03.hasAllVowels("A e   I o     U"));
        assertTrue(Exercise03.hasAllVowels("asdfppeqooiiueru;lkjasdfa"));
        assertTrue(Exercise03.hasAllVowels("AsdfppeqOiiueru;lkjasdfa"));

        assertFalse(Exercise03.hasAllVowels(null));
        assertFalse(Exercise03.hasAllVowels(""));
        assertFalse(Exercise03.hasAllVowels("qwrtypsdfghjklzxcvbnm"));
        assertFalse(Exercise03.hasAllVowels("aeio"));
        assertFalse(Exercise03.hasAllVowels("eio"));
    }
}