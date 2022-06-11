package medium;

import java.util.*;

/**
 * https://leetcode.com/problems/132-pattern/
 */
public class Pattern132 {

    /**
     * 1. looking for '32' pattern from right to left direction
     * 2. put '2' value into the 'right' variable
     * 3. put '3' value into the maxIndex
     * 4. if current ('1') < right ('2') than true
     * 5. otherwise we cannot find '2' or cannot find '1' that less than '2'
     */
    public static boolean find132pattern(int[] nums) {
        int maxIndex = nums.length;//pointer for '3' value
        int right = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            //4
            if (current < right) {
                return true;
            }
            //1
            while (maxIndex < nums.length && current > nums[maxIndex] ) {
                //2
                right = nums[maxIndex];
                maxIndex++;
            }
            //3
            nums[--maxIndex] = current;
        }
        //5
        return false;
    }

    public static boolean find132patternViaStack(int[] nums) {
        int min = nums[0];
        Stack<int[]> stack = new Stack<>(); //keep current max and prev min values

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            //if current value is bigger than existed MAX in the stack, we remove it from the stack
            while (!stack.isEmpty() && current >= stack.peek()[0]) {
                stack.pop();
            }
            //if we still have in the stack any values it means, that current value is less than any existed MAX in the stack.
            //So we can check that the current value bigger than min value for the MAX value.
            if (!stack.isEmpty() && current > stack.peek()[1]) {
                return true;
            }
            stack.add(new int[]{current, min});
            min = Math.min(min, current);
        }
        return false;
    }

    public static boolean find132patternBruteForce(int[] nums) {
        for (int k = nums.length - 1; k > 1; k--) {
            int right = nums[k];
            for (int j = k - 1; j > 0; j--) {
                int middle = nums[j];
                for (int i = j - 1; i >= 0; i--) {
                    int left = nums[i];
                    if (left < right && right < middle) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
