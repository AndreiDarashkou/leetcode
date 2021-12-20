package test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flood-fill/
 * <p>
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {

    public static void main(String[] args) {
        //int[][] image = new int[][]{{1, 1, 1, 1}, {1, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 1, 0}};

        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        floodFill(image, 1, 1, 1);
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] floodFill(int[][] image, int row, int col, int newColor) {
        int oldColor = image[row][col];
        if (oldColor == newColor) {
            return image;
        }

        draw(image, row, col, oldColor, newColor);

        return image;
    }

    private static void draw(int[][] image, int row, int col, int oldColor, int color) {
        image[row][col] = color;
        if (row + 1 < image.length && image[row + 1][col] == oldColor) {
            draw(image, row + 1, col, oldColor, color);
        }
        if (row > 0 && image[row - 1][col] == oldColor) {
            draw(image, row - 1, col, oldColor, color);
        }
        if (col + 1 < image[0].length && image[row][col + 1] == oldColor) {
            draw(image, row, col + 1, oldColor, color);
        }
        if (col > 0 && image[row][col - 1] == oldColor) {
            draw(image, row, col - 1, oldColor, color);
        }
    }
}
