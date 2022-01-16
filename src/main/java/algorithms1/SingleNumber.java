package algorithms1;

/**
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * 1 <= nums.length <= 3 * 10^4
 * -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears only once.
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int unique = 0;
        for (int n : nums) {
            unique = unique ^ n;
        }
        return unique;
    }

}
