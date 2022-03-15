package algorithms2;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * <p>
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {

    private static final int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static char[][] solve(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'O') {
                markAllRelatives(0, col, board);
            }
            if (board[board.length - 1][col] == 'O') { //check top and bottom
                markAllRelatives(board.length - 1, col, board);
            }
        }
        for (int row = 0; row < board.length; row++) { //check left and right
            if (board[row][0] == 'O') {
                markAllRelatives(row, 0, board);
            }
            if (board[row][board[0].length - 1] == 'O') {
                markAllRelatives(row, board[0].length - 1, board);
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'B') {
                    board[r][c] = 'O';
                } else {
                    board[r][c] = 'X';
                }
            }
        }
        return board;
    }

    private static void markAllRelatives(int row, int col, char[][] board) {
        board[row][col] = 'B';
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O') {
                markAllRelatives(r, c, board);
            }
        }
    }

}
