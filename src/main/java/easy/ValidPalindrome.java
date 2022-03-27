package easy;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String text) {
        byte[] bytes = text.getBytes();
        int head = 0;
        int tail = bytes.length - 1;

        while (head < tail) {
            if (!isNumberOrLetter(bytes[head])) {
                head++;
                continue;
            }
            if (!isNumberOrLetter(bytes[tail])) {
                tail--;
                continue;
            }

            boolean notEqualCodes = bytes[head] != bytes[tail];
            boolean isLetter = bytes[head] >= 65 && bytes[tail] >= 65;
            boolean isEqualLetters = isLetter && Math.abs(bytes[head] - bytes[tail]) == 32;
            if (notEqualCodes && !isEqualLetters) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    private static boolean isNumberOrLetter(byte symbol) {
        return (symbol >= 48 && symbol <= 57) || (symbol >= 65 && symbol <= 90) || (symbol >= 97 && symbol <= 122);
    }
}
