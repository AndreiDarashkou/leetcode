package easy;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * <p>
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if ((nums[left] ^ 1) > nums[left]) {
                left++;
                continue;
            }
            if ((nums[right] ^ 1) < nums[right]) {
                right--;
                continue;
            }
            int lefVal = nums[left];
            nums[left] = nums[right];
            nums[right] = lefVal;
        }
        return nums;
    }
}
