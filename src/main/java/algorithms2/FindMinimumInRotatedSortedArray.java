package algorithms2;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
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
        return nums[max];
    }
}
