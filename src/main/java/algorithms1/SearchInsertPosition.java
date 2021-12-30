package algorithms1;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private static int searchInsert(int[] nums, int target, int min, int max) {
        if (min == max || max - min == 1) {
            if (nums[min] == target) return min;
            if (nums[max] == target) return max;

            if (nums[min] < target) return min + 1;
            if (nums[max] > target) return max - 1;
        }
        int pivot = (min + max) / 2;
        if (nums[pivot] > target) {
            return searchInsert(nums, target, min, pivot);
        }
        if (nums[pivot] < target) {
            return searchInsert(nums, target, pivot, max);
        }
        return pivot;
    }
}
