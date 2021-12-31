package algorithms1;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * <p>
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (l > r) {
                res[index--] = l;
                left++;
            } else {
                res[index--] = r;
                right--;
            }
        }
        return res;
    }
}
