package algorithms1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        return combine(1, n, k, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> combine(int from, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) { //current list already contains k elements
            result.add(list);
            return result;
        }
        int canAdd = n - from + 1;
        if (canAdd + list.size() < k) { //no sense to move forward with this list, because we won't achieve k elements
            return result;
        }
        int to = Math.min(n - k + from, n); //truncate deep, if k == 3 => no sense to check > 3 next elements
        for (int i = from; i <= to; i++) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(i);

            combine(i + 1, n, k, temp, result);
        }
        return result;
    }
}
