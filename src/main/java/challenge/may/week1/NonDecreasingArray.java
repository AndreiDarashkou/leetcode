package challenge.may.week1;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3731/
 * <p>
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        boolean swapped = false;
        for (int current = 0, next = 1; next < nums.length; current++, next++) {
            if (nums[current] > nums[next]) {
                if (swapped) {
                    return false;
                }
                swapped = true;
                if (current == 0 || next == nums.length - 1) {
                    continue;
                }

                boolean changeCurrent = nums[current] > nums[next + 1];
                boolean changeNext = nums[current - 1] > nums[next];

                if (changeCurrent && changeNext) {
                    return false;
                }

                if (changeCurrent) {
                    nums[current] = nums[next];
                } else {
                    nums[next] = nums[current];
                }
            }
        }
        return true;
    }
}
