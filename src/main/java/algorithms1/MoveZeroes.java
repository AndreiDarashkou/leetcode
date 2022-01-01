package algorithms1;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

    public static int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[index++] = n;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }

        return nums;
    }
}
