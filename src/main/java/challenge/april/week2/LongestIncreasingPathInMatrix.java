package challenge.april.week2;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3703/
 * <p>
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move
 * outside the boundary (i.e., wrap-around is not allowed).
 */
public class LongestIncreasingPathInMatrix {

    private int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        cache = new int[matrix.length][matrix[0].length];
        int longestPath = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int maxPath = maxPathFrom(row, col, matrix, 1);
                if (maxPath > longestPath) {
                    longestPath = maxPath;
                }
            }
        }
        return longestPath;
    }

    private int maxPathFrom(int row, int col, int[][] matrix, int maxPath) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int result = maxPath;

        if (row > 0 && matrix[row][col] < matrix[row - 1][col]) { //top available
            int max = maxPath + maxPathFrom(row - 1, col, matrix, maxPath);
            if (max > result) {
                result = max;
            }
        }
        if (row + 1 < matrix.length && matrix[row][col] < matrix[row + 1][col]) { //bottom available
            int max = maxPath + maxPathFrom(row + 1, col, matrix, maxPath);
            if (max > result) {
                result = max;
            }
        }
        if (col + 1 < matrix[0].length && matrix[row][col] < matrix[row][col + 1]) { //right available
            int max = maxPath + maxPathFrom(row, col + 1, matrix, maxPath);
            if (max > result) {
                result = max;
            }
        }
        if (col > 0 && matrix[row][col] < matrix[row][col - 1]) { //left available
            int max = maxPath + maxPathFrom(row, col - 1, matrix, maxPath);
            if (max > result) {
                result = max;
            }
        }

        cache[row][col] = result;

        return result;
    }

}
