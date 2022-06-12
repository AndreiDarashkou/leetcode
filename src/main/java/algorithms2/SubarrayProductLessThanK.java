package algorithms2;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp >= k) {
                continue;
            }
            count++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= k) {
                    break;
                }
                temp = temp * nums[j];
                if (temp >= k) {
                    break;
                }
                count++;
            }
        }
        return count;
    }
}
