package algorithms1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Matrix01 {

    public static int[][] updateMatrix(int[][] mat) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    mat[i][j] = -1;
                else {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int distance = 1;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] pos = queue.pop();

                for (int[] dir : dirs) {
                    int r = dir[0] + pos[0];
                    int c = dir[1] + pos[1];

                    if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || mat[r][c] != -1) {
                        continue;
                    }
                    mat[r][c] = distance;
                    queue.addLast(new int[]{r, c});
                }
            }
            distance++;
        }
        return mat;
    }

}
