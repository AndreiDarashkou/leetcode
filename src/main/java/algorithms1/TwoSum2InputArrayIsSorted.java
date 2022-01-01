package algorithms1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
 * and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class TwoSum2InputArrayIsSorted {

    public static int[] twoSum1(int[] numbers, int target) {
        Map<Integer, Integer> toFindMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (toFindMap.containsKey(numbers[i])) {
                return new int[]{toFindMap.get(numbers[i]) + 1, i + 1};
            }
            int toFind = target - numbers[i];
            toFindMap.put(toFind, i);
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }
}
