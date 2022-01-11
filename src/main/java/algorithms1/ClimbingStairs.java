package algorithms1;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}