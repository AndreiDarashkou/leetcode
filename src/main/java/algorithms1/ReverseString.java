package algorithms1;

/**
 * https://leetcode.com/problems/reverse-string/
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

    public static char[] reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            if (temp != s[right]) {
                s[left] = s[right];
                s[right] = temp;
            }
            left++;
            right--;
        }
        return s;
    }

    public static char[] reverseString2(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            int right = s.length - 1 - i;
            if (temp != s[right]) {
                s[i] = s[right];
                s[right] = temp;
            }
        }
        return s;
    }
}
