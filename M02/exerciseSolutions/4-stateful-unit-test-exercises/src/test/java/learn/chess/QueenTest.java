package learn.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Queen queen = new Queen();

    // 1. Add tests to validate Queen movement.
    @Test
    void shouldMoveToFourCorners() {
        assertTrue(queen.move(7, 0)); // top left;
        assertEquals(7, queen.getRow());
        assertEquals(0, queen.getColumn());

        assertTrue(queen.move(7, 7)); // top right;
        assertEquals(7, queen.getRow());
        assertEquals(7, queen.getColumn());

        assertTrue(queen.move(0, 7)); // bottom right;
        assertEquals(0, queen.getRow());
        assertEquals(7, queen.getColumn());

        assertTrue(queen.move(0, 0)); // bottom left;
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
    }

    // - anything off the board is invalid, should return false and leave field values alone.
    @Test
    void shouldNotMoveOffBoard() {
        assertFalse(queen.move(11, 11));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());

        assertFalse(queen.move(11, 7));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());

        assertFalse(queen.move(5, 15));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
    }

    // - requesting the existing location should return false and leave field values alone.
    @Test
    void movingToExistingLocationReturnsFalseLeavesValuesAlone() {
        assertFalse(queen.move(0, 0));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
    }

    // - should still be able to move after an invalid move.
    @Test
    void shouldStillBeAbleToMoveAfterInvalidMove() {
        assertFalse(queen.move(15, 15));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());

        assertTrue(queen.move(7, 7));
        assertEquals(7, queen.getRow());
        assertEquals(7, queen.getColumn());
    }

    // - can move diagonally in various ways
    @Test
    void shouldMoveDiagonallyInVariousWays() {
        assertTrue(queen.move(1, 1));
        assertEquals(1, queen.getRow());
        assertEquals(1, queen.getColumn());

        assertTrue(queen.move(2, 2));
        assertEquals(2, queen.getRow());
        assertEquals(2, queen.getColumn());

        assertTrue(queen.move(5, 5));
        assertEquals(5, queen.getRow());
        assertEquals(5, queen.getColumn());

        assertTrue(queen.move(3, 3));
        assertEquals(3, queen.getRow());
        assertEquals(3, queen.getColumn());
    }
    // Always confirm that fields have been properly updated using getters.
}