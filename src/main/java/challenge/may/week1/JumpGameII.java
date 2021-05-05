package challenge.may.week1;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int[] avail = new int[nums.length];
        Arrays.fill(avail, -1);

        for (int j = 0; j < nums.length; j++) {
            int pos = Math.min(nums[j] + j, nums.length - 1);
            for (int i = j + 1; i <= pos; i++) {
                if (avail[i] == -1 || avail[i] > j) {
                    avail[i] = j;
                }
            }
        }
        int jumps = 0;
        for (int i = nums.length - 1; i > 0; ) {
            i = avail[i];
            jumps++;
        }
        return jumps;
    }
}
