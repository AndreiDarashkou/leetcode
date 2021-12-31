package algorithms1;

/**
 * https://leetcode.com/problems/rotate-array/
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 */
public class RotateArray {

    public static int[] rotate1(int[] nums, int k) {
        int size = nums.length;
        if (k == 0 || k == size) {
            return nums;
        }
        k = k % size;

        int[] temp = new int[k]; //keep tail
        for (int i = 0; i < k; i++) {
            temp[i] = nums[size + i - k];
        }
        for (int i = size - 1, j = k; i >= k; i--, j--) {//shift elements
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {//copy tail
            nums[i] = temp[i];
        }

        return nums;
    }

    public static int[] rotate2(int[] nums, int k) {
        int size = nums.length;
        if (k == 0 || k == size) {
            return nums;
        }
        k = k % size;

        //input: 1,2,3,4,5,6,7
        reverse(nums, 0, size - 1);//7,6,5,4,3,2,1
        reverse(nums, 0, k - 1);//5,6,7,4,3,2,1
        reverse(nums, k, size - 1);//5,6,7,1,2,3,4

        return nums;
    }

    private static void reverse(int[] nums, int from, int to) {
        while (from < to) {
            int temp = nums[from];
            nums[from] = nums[to];
            nums[to] = temp;
            from++;
            to--;
        }
    }
}
