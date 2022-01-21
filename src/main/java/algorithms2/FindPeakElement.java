package algorithms2;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    //todo rewrite to O(logN)
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 2] < nums[i - 1] && nums[i - 1] > nums[i]) {
                return i - 1;
            }
        }

        return -1;
    }

}
