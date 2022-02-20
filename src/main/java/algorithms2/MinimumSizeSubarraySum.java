package algorithms2;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
 * of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int sum = 0;
        int first = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                length = Math.min(length, i - first + 1);
                sum = sum - nums[first];
                first++;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}
