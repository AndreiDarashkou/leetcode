package algorithms1;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below.
 * More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> prevRow = triangle.get(i - 1);

            row.set(0, row.get(0) + prevRow.get(0));

            for (int j = 1; j < i; j++) {
                int min = Math.min(prevRow.get(j - 1), prevRow.get(j));
                row.set(j, row.get(j) + min);
            }

            row.set(i, row.get(i) + prevRow.get(i - 1));
        }
        return triangle.get(triangle.size() - 1).stream().min(Integer::compareTo).orElse(0);
    }

}
