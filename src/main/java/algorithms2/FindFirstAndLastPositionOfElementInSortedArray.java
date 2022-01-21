package algorithms2;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }

        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (nums[middle] == target) {
                return range(nums, middle, target);
            }
            if (nums[middle] < target) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] range(int[] nums, int index, int target) {
        int left = index;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (index < nums.length && nums[index] == target) {
            index++;
        }
        return new int[]{left + 1, index - 1};
    }
}
