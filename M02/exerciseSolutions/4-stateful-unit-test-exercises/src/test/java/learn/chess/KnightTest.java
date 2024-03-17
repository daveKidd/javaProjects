package learn.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    Knight knight = new Knight();

    // 1. Add tests to validate Knight movement.  Could add down and up left
    @Test
    void shouldMoveFromStartingPlaceToAllOver() {
        assertTrue(knight.move(2, 1)); // move up and to the right
        assertEquals(2, knight.getRow());
        assertEquals(1, knight.getColumn());

        assertTrue(knight.move(0, 2)); // down to the right
        assertEquals(0, knight.getRow());
        assertEquals(2, knight.getColumn());

        assertTrue(knight.move(2, 1)); // up to the left
        assertEquals(2, knight.getRow());
        assertEquals(1, knight.getColumn());

        assertTrue(knight.move(3, 3)); // right and then up
        assertEquals(3, knight.getRow());
        assertEquals(3, knight.getColumn());

        assertTrue(knight.move(4, 1)); // left and then up
        assertEquals(4, knight.getRow());
        assertEquals(1, knight.getColumn());

        assertTrue(knight.move(3, 3)); // right and then down
        assertEquals(3, knight.getRow());
        assertEquals(3, knight.getColumn());

        assertTrue(knight.move(2, 1)); // left and then down
        assertEquals(2, knight.getRow());
        assertEquals(1, knight.getColumn());

        assertFalse(knight.move(6, 6)); // invalid move from current location
        assertEquals(2, knight.getRow());
        assertEquals(1, knight.getColumn());
    }

    // - anything off the board is invalid, should return false and leave field values alone.
    @Test
    void shouldNotMoveOffBoard() {
        assertFalse(knight.move(11, 11));
        assertEquals(0, knight.getRow());
        assertEquals(0, knight.getColumn());

        assertFalse(knight.move(11, 7));
        assertEquals(0, knight.getRow());
        assertEquals(0, knight.getColumn());

        assertFalse(knight.move(5, 15));
        assertEquals(0, knight.getRow());
        assertEquals(0, knight.getColumn());
    }

    // - requesting the existing location should return false and leave field values alone.
    @Test
    void movingToExistingLocationReturnsFalseLeavesValuesAlone() {
        assertFalse(knight.move(0, 0));
        assertEquals(0, knight.getRow());
        assertEquals(0, knight.getColumn());
    }

    // - should still be able to move after an invalid move.
    @Test
    void shouldStillBeAbleToMoveAfterInvalidMove() {
        assertFalse(knight.move(15, 15));
        assertEquals(0, knight.getRow());
        assertEquals(0, knight.getColumn());

        assertTrue(knight.move(1, 2));
        assertEquals(1, knight.getRow());
        assertEquals(2, knight.getColumn());
    }
}