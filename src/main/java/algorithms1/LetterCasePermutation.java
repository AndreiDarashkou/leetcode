package algorithms1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 * <p>
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 */
public class LetterCasePermutation {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b"));
    }

    public static List<String> letterCasePermutation(String str) {
        List<String> res = new ArrayList<>();
        variants(str.toCharArray(), 0, res);
        return res;
    }

    private static void variants(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        variants(chars, index + 1, result);
        if (isLowerCase(chars[index])) {
            chars[index] = (char) (chars[index] - 32);
            variants(chars, index + 1, result);
        } else if (isUpperCase(chars[index])) {//upper case
            chars[index] = (char) (chars[index] + 32);
            variants(chars, index + 1, result);
        }
    }

    private static boolean isLowerCase(char ch) {
        return ch <= 122 && ch >= 97;
    }

    private static boolean isUpperCase(char ch) {
        return ch <= 90 && ch >= 65;
    }
}
