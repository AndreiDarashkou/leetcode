package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        int[][] grid2 = new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 1, 0, 1}};
        System.out.println(maxAreaOfIsland(grid2));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != 1) {
                    continue;
                }
                current = 0;
                checkSize(grid, row, col);
                max = Math.max(max, current);
            }
        }
        return max;
    }

    private static int current = 0;

    private static void checkSize(int[][] grid, int row, int col) {
        current++;
        grid[row][col] = -1;

        if (row > 0 && grid[row - 1][col] == 1) {
            checkSize(grid, row - 1, col);
        }
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            checkSize(grid, row + 1, col);
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            checkSize(grid, row, col - 1);
        }
        if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
            checkSize(grid, row, col + 1);
        }
    }
}
