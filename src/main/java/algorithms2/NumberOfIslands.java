package algorithms2;

/**
 * https://leetcode.com/problems/number-of-islands/
 * <p>
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int counter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    markIsland(grid, row, col);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void markIsland(char[][] grid, int row, int col) {
        if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length) {
            if (grid[row][col] == '1') {
                grid[row][col] = '2';

                markIsland(grid, row + 1, col);
                markIsland(grid, row - 1, col);
                markIsland(grid, row, col + 1);
                markIsland(grid, row, col - 1);
            }
        }
    }
}
