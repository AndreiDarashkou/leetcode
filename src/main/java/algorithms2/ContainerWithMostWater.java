package algorithms2;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = Math.min(height[0], height[height.length - 1]) * (height.length - 1);

        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            if (leftVal < rightVal) {
                while (leftVal >= height[left]) {
                    left++;
                }
            } else {
                while (rightVal >= height[right] && right > left) {
                    right--;
                }
            }
            int temp = Math.min(height[left], height[right]) * (right - left);
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
