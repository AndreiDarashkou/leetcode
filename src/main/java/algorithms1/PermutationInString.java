package algorithms1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {

    public static boolean checkInclusion(String subStr, String fullStr) {
        if (subStr.length() > fullStr.length()) {
            return false;
        }

        int[] substring = new int[26];
        for (char ch : subStr.toCharArray()) {
            substring[ch - 97]++;
        }

        char[] chars = fullStr.toCharArray();
        int[] current = new int[26];
        for (int i = 0; i < subStr.length() - 1; i++) {
            current[chars[i] - 97]++;
        }

        int length = subStr.length();
        for (int i = 0; i <= chars.length - length; i++) {
            char lastCh = chars[i + length - 1];
            current[lastCh - 97]++;

            if (equals(substring, current)) {
                return true;
            }
            current[chars[i] - 97]--;
        }
        return false;
    }

    private static boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    //the same logic but use HashMap for holding ad comparing substring and 'frame' string
    public static boolean checkInclusion2(String subStr, String fullStr) {
        if (subStr.length() > fullStr.length()) {
            return false;
        }

        Map<Character, Integer> consistence = new HashMap<>();
        for (char ch : subStr.toCharArray()) {
            int count = consistence.containsKey(ch) ? consistence.get(ch) + 1 : 1;
            consistence.put(ch, count);
        }

        char[] strChars = fullStr.toCharArray();
        Map<Character, Integer> current = new HashMap<>();
        for (int i = 0; i < subStr.length(); i++) {
            int count = current.containsKey(strChars[i]) ? current.get(strChars[i]) + 1 : 1;
            current.put(strChars[i], count);
        }

        for (int i = 0; i < strChars.length - subStr.length(); i++) {
            if (consistence.equals(current)) {
                return true;
            }

            char first = strChars[i];
            char next = strChars[i + subStr.length()];
            Integer count = current.get(first);
            if (count == 1) {
                current.remove(first);
            } else {
                current.put(first, count - 1);
            }
            int countNext = current.containsKey(next) ? current.get(next) + 1 : 1;
            current.put(next, countNext);
        }
        return consistence.equals(current);
    }

}
