package practise;

public class SudokuSolver {

    private static final int GRID_SIZE = 9;
    private static final int MATRIX_LENGTH = 3;
    private static final int GRID_FIRST_VALUE = 1;
    private static final int GRID_LAST_VALUE = 9;

    public static void main(String[] args) {
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        printBoard(board);
        if (isSolveBoard(board)) {
            System.out.println("Solved successfully!");
        } else {
            System.out.println("Unsolvable board :(");
        }
        printBoard(board);
    }


    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % 3 == 0 && column != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * check a board is valid or invalid
     * if current position(row,column) or 3*3 matrix is not valid return false, otherwise true
     * @param board
     * @return boolean
     */
    public static boolean isValidBoard(int[][] board) {
        for(int rowIndex = 0; rowIndex < GRID_SIZE; rowIndex++) {
            for(int columnIndex = 0; columnIndex < GRID_SIZE; columnIndex++) {
                int currentValue = board[rowIndex][columnIndex];
                if (currentValue < GRID_FIRST_VALUE || currentValue > GRID_LAST_VALUE) { /*throw an exception there*/};
                if (!isValidPlacement(board, currentValue, rowIndex, rowIndex)) return false;
            }
        }
        return true;
    }

    /**
     * Check a number is valid on a position (x,y) and 3*3 matrix
     * @param board, number, row, column
     * @return boolean
     */
    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        for (int index = 0; index < GRID_SIZE; index++) {
            if (board[row][index] == number) return false;
            if (board[index][column] == number) return false;
        }

        // check 3*3 matrix
        int rowBorder = row - row % MATRIX_LENGTH;
        int columnBorder = column - column % MATRIX_LENGTH;
        for (int rowIndex = rowBorder; rowIndex < rowBorder + MATRIX_LENGTH; rowIndex++) {
            for (int columnIndex = columnBorder; columnIndex < columnBorder + MATRIX_LENGTH; columnIndex++) {
                if (board[rowIndex][columnIndex] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check a board is solved or not, using recursion call (isSolveBoard) method
     * @param board
     * @return boolean
     */
    public static boolean isSolveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                // looking for next position
                if (board[row][column] == 0) {
                    // if its fail to place a number then return false
                    for (int numberToTry = GRID_FIRST_VALUE; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;
                            // after set the value we recursively call the board again to solve next position
                            // if we can't solve the board that means this number can't solve the board rest position
                            // so we clear it, set 0 and try another number
                            if (isSolveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}



