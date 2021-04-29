package challenge.april.week5;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3725/
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }

        int st = index;
        for (int i = index; i >= 0; i--) {
            if (nums[i] == target) {
                st = i;
            }
            if (nums[index] < target) {
                break;
            }
        }

        int end = index;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == target) {
                end = i;
            }
            if (nums[index] > target) {
                break;
            }
        }

        return new int[]{st, end};
    }
}
