package algorithms1;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int days = 0;
        int queueSize = queue.size();
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            if (queueSize == 0) {
                queueSize = queue.size();
                days++;
            }
            int[] rotted = queue.poll();
            queueSize--;
            for (int[] dir : dirs) {
                int x = dir[0] + rotted[0];
                int y = dir[1] + rotted[1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
                    continue;
                }
                grid[x][y] = 2;
                freshCount--;
                queue.add(new int[]{x, y});
            }
        }
        return freshCount == 0 ? days : -1;
    }

    public static int orangesRotting2(int[][] grid) {
        int lastRotted = 2;
        int days = 0;
        boolean rotted;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        do {
            rotted = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == lastRotted) {
                        for (int[] dir : dirs) {
                            int x = dir[0] + i;
                            int y = dir[1] + j;
                            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
                                continue;
                            }
                            grid[x][y] = lastRotted + 1;
                            rotted = true;
                        }
                    }
                }
            }
            lastRotted += 1;
            if (rotted) {
                days++;
            }
        } while (rotted);

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return days;
    }
}
