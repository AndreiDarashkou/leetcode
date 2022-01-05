package algorithms1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/flood-fill/
 * <p>
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {

    //recursive approach
    public static int[][] floodFill(int[][] image, int row, int col, int newColor) {
        int oldColor = image[row][col];
        if (oldColor == newColor) {
            return image;
        }
        draw(image, row, col, oldColor, newColor);

        return image;
    }

    private static void draw(int[][] image, int row, int col, int oldColor, int color) {
        if (row < 0 || col < 0 || row > image.length - 1 || col > image[0].length - 1 || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = color;
        draw(image, row + 1, col, oldColor, color);
        draw(image, row - 1, col, oldColor, color);
        draw(image, row, col + 1, oldColor, color);
        draw(image, row, col - 1, oldColor, color);
    }

    //stack based approach
    public static int[][] floodFill2(int[][] image, int row, int col, int newColor) {
        int oldColor = image[row][col];
        if (oldColor == newColor) {
            return image;
        }

        Deque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int posRow = pos[0];
            int posCol = pos[1];
            if (image[posRow][posCol] == newColor) {
                continue;
            }
            image[posRow][posCol] = newColor;

            if (posRow + 1 < image.length && image[posRow + 1][posCol] == oldColor) {
                stack.add(new int[]{posRow + 1, posCol});
            }
            if (posRow > 0 && image[posRow - 1][posCol] == oldColor) {
                stack.add(new int[]{posRow - 1, posCol});
            }
            if (posCol + 1 < image[0].length && image[posRow][posCol + 1] == oldColor) {
                stack.add(new int[]{posRow, posCol + 1});
            }
            if (posCol > 0 && image[posRow][posCol - 1] == oldColor) {
                stack.add(new int[]{posRow, posCol - 1});
            }
        }
        return image;
    }

    //span filling approach
    public static int[][] floodFill3(int[][] image, int row, int col, int newColor) {
        int oldColor = image[row][col];
        if (oldColor == newColor) {
            return image;
        }

        Deque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{row, col});

        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int posCol = pos[1];

            int up = pos[0];
            int down = pos[0];

            int rowUp = pos[0] - 1;
            while (rowUp >= 0 && image[rowUp][posCol] == oldColor) {
                up = rowUp;
                image[rowUp--][posCol] = newColor;
            }

            int rowDown = pos[0];
            while (rowDown < image.length && image[rowDown][posCol] == oldColor) {
                down = rowDown;
                image[rowDown++][posCol] = newColor;
            }
            scan(image, down, up, posCol + 1, stack, oldColor);
            scan(image, down, up, posCol - 1, stack, oldColor);
        }
        return image;
    }

    private static void scan(int[][] image, int rowDown, int rowUp, int col, Deque<int[]> stack, int oldColor) {
        if (col < 0 || col > image[0].length - 1) {
            return;
        }
        for (int i = rowUp; i <= rowDown; i++) {
            if (image[i][col] == oldColor) {
                stack.add(new int[]{i, col});
            }
        }
    }
}
