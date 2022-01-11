package algorithms1;

/**
 * https://leetcode.com/problems/house-robber/
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        int one = 0;//ahead
        int two = 0;//previous

        for (int num : nums) {
            int temp = one;
            one = Math.max(one, two + num);
            two = temp;
        }

        return one;
    }
}
