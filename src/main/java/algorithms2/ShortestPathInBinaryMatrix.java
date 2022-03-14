package algorithms2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathInBinaryMatrix {

    private final static int[][] dirs = new int[][]{{1, 1}, {1, 0}, {0, 1}, {-1, 1}, {1, -1}, {-1, 0}, {0, -1}, {-1, -1}};

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0][0] != 0 || grid[grid.length - 1][grid.length - 1] != 0) {
            return -1;
        }

        boolean[][] visited = new boolean[grid.length][grid.length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        int deep = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            deep++;

            while (size-- > 0) {
                int[] point = queue.remove();
                int row = point[0];
                int col = point[1];
                grid[row][col] = deep;

                for (int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r >= 0 && c >= 0 && r < grid.length && c < grid.length && grid[r][c] != 1) {
                        if (grid[r][c] == 0 && !visited[r][c]) {
                            visited[r][c] = true;
                            queue.add(new int[]{r, c});
                        }
                    }
                }
            }
        }

        int length = grid[grid.length - 1][grid.length - 1];

        return length == 0 ? -1 : length - 1;
    }

}