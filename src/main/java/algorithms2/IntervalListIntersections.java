package algorithms2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);

            if (right >= left) {
                result.add(new int[]{left, right});
            }

            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[result.size()][2];
        for (int k = 0; k < res.length; k++) {
            res[k] = result.get(k);
        }
        return res;
    }
}
