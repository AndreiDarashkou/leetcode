package algorithms1;

/**
 * https://leetcode.com/problems/binary-search/
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int min, int max, int target) {
        if (min == max || max - min == 1) {
            if (nums[min] == target) return min;
            if (nums[max] == target) return max;
            return -1;
        }
        int pivot = (min + max) / 2;

        if (nums[pivot] > target) {
            return search(nums, min, pivot, target);
        }
        if (nums[pivot] < target) {
            return search(nums, pivot, max, target);
        }
        return pivot;
    }
}
