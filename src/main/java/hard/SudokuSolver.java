package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * <p>
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public final class SudokuSolver {

    private static final List<Character> NUMBERS = new ArrayList<>();

    static {
        NUMBERS.add('1');
        NUMBERS.add('2');
        NUMBERS.add('3');
        NUMBERS.add('4');
        NUMBERS.add('5');
        NUMBERS.add('6');
        NUMBERS.add('7');
        NUMBERS.add('8');
        NUMBERS.add('9');
    }

    public static void solveSudoku(char[][] board) {
        List<int[]> emptyCells = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    emptyCells.add(new int[]{row, col});
                }
            }
        }
        solveSudoku(board, emptyCells, 0);
    }

    public static boolean solveSudoku(char[][] board, List<int[]> emptyCells, int index) {
        if (index >= emptyCells.size()) {
            return true;
        }
        int row = emptyCells.get(index)[0];
        int col = emptyCells.get(index)[1];

        List<Character> suitable = suitable(board, row, col);
        if (suitable.isEmpty()) {
            return false;
        }
        for (char ch : suitable) {
            board[row][col] = ch;
            if (solveSudoku(board, emptyCells, index + 1)) {
                return true;
            } else {
                board[row][col] = '.';
            }
        }

        return false;
    }

    private static List<Character> suitable(char[][] board, int row, int col) {
        List<Character> arr = new ArrayList<>(NUMBERS);
        for (int i = 0; i < 9; i++) {
            arr.remove((Character) board[row][i]);
            arr.remove((Character) board[i][col]);
        }
        if (row < 3) {
            row = 0;
        } else if (row < 6) {
            row = 3;
        } else {
            row = 6;
        }
        if (col < 3) {
            col = 0;
        } else if (col < 6) {
            col = 3;
        } else {
            col = 6;
        }
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                arr.remove((Character) board[i][j]);
            }
        }
        return arr;
    }
}
