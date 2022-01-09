package algorithms1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        Deque<Integer> sourceList = new ArrayDeque<>();
        for (int n : nums) {
            sourceList.add(n);
        }
        return permute(sourceList);
    }

    public static List<List<Integer>> permute(Deque<Integer> nums) {
        if (nums.size() == 1) {
            return List.of(new ArrayList<>(nums));
        }

        List<List<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer extracted = nums.pollFirst();

            List<List<Integer>> permute = permute(nums);
            permute.forEach(sub -> sub.add(extracted));

            permutations.addAll(permute);
            nums.addLast(extracted);
        }
        return permutations;
    }
}