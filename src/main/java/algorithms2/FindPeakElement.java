package algorithms2;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

}
