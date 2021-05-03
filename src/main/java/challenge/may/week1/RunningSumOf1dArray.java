package challenge.may.week1;

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/
 */
public class RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] += nums[i];
        }
        return nums;
    }
}
