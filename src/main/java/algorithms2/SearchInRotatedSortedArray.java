package algorithms2;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {//todo rewrite, simplify

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int pivot = findMinIndex(nums);
        int minElement = nums[pivot];
        int maxElement = nums[pivot == 0 ? nums.length - 1 : pivot - 1];
        if (target < minElement || target > maxElement) {
            return -1;
        }
        if (nums[nums.length - 1] >= target) {
            return binarySearch(nums, target, pivot, nums.length - 1);
        }
        return binarySearch(nums, target, 0, pivot == 0 ? nums.length - 1 : pivot - 1);
    }

    private static int binarySearch(int[] nums, int target, int min, int max) {
        if (min > max) {
            return -1;
        }
        int mid = (min + max) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarySearch(nums, target, min, mid - 1);
        }
        return binarySearch(nums, target, mid + 1, max);
    }

    private static int findMinIndex(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) {
            return 0;
        }
        int min = 0;
        int max = nums.length - 1;

        while (min != max - 1) {
            int middle = (min + max) / 2;

            if (nums[min] < nums[middle]) {
                min = middle;
            } else {
                max = middle;
            }
        }
        return max;
    }
}
