package learn.chess;

/**
 * The knight!
 * Moves up or down two spaces and to the side one or to the side two spaces and up or down one
 * He tracks his current position with two integer fields: row and column.
 * Rows and columns are zero-based.
 * The Knight starts at row 0 and column 0, though there is no board.
 * Row 7 - - - - - - - -
 * Row 6 - - - - - - - -
 * Row 5 - - - - - - - -
 * Row 4 - - - - - - - -
 * Row 3 - - - - - - - -
 * Row 2 - - - - - - - -
 * Row 1 - - - - - - - -
 * Row 0 K - - - - - - -
 * Cols: 0 1 2 3 4 5 6 7
 * <p>
 * See: https://en.wikipedia.org/wiki/Knight_(chess)
 */
public class Knight {

    private int row = 0;
    private int column = 0;

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Requests a move to a new row and column.
     *
     * @param row    the requested row
     * @param column the requested column
     * @return true if the move is valid, false if it's not
     */
    public boolean move(int row, int column) {

        // 1. Implement the move method.
        // If the move is valid, return true and update `row` and `column` fields.
        // If the move is invalid, return false and do not update fields.
        // Rules for valid moves:
        // - row and column can never be less than 0 or greater than 7 (8 rows and columns on a chess board).
        // - can't equal the existing row and column (same location)
        // - A valid move is adding or subtracting two from the row and adding or subtracting one from the column
        // - Another valid move is adding or subtracting two from the column and adding or subtracting one from the row
        if((row >= 0 && row <= 7) && (column >= 0 && column <= 7)){
            if(((row == getRow() + 2 || row == getRow() - 2) && (column == getColumn() + 1 || column == getColumn() - 1))
                || ((column == getColumn() + 2 || column == getColumn() - 2) && (row == getRow() +1 || row == getRow() - 1))){
                setRow(row);
                setColumn(column);
                return true;
            }
        }
        return false;
    }
}
