package medium;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (!checkRow(row)) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            if (!checkCol(board, col)) {
                return false;
            }
        }

        int[][] direction = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
        for (int[] cell : direction) {
            byte[] counter = new byte[9];
            for (int row = cell[0]; row < cell[0] + 3; row++) {
                for (int col = cell[1]; col < cell[1] + 3; col++) {
                    char ch = board[row][col];
                    if (duplicated(counter, ch)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean checkRow(char[] row) {
        byte[] counter = new byte[9];
        for (char ch : row) {
            if (duplicated(counter, ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(char[][] board, int col) {
        byte[] counter = new byte[9];
        for (int row = 0; row < 9; row++) {
            char ch = board[row][col];
            if (duplicated(counter, ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean duplicated(byte[] counter, char ch) {
        if (ch == '.') {
            return false;
        }
        int chCode = ch - '1';
        if (counter[chCode] == 1) {
            return true;
        }
        counter[chCode]++;
        return false;
    }
}
