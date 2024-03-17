import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise02Test {

    @Test
    void surroundWithTags() {
        assertEquals("<boom>abc</boom>", Exercise02.surroundWithTag("abc", "boom"));
        assertEquals("<fact>Cats are mean.</fact>", Exercise02.surroundWithTag("Cats are mean.", "fact"));
        assertEquals("this is just text", Exercise02.surroundWithTag("this is just text", ""));
        assertEquals("<span></span>", Exercise02.surroundWithTag(null, "span"));
        assertEquals("splendid", Exercise02.surroundWithTag("splendid", null));
    }
}