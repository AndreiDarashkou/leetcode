package test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] fr = new int[26];
        for (char ch : s1.toCharArray()) {
            fr[ch - 97]++;
        }

        char[] chars = s2.toCharArray();
        int[] cur = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            cur[chars[i] - 97]++;
        }

        int length = s1.length();
        for (int i = 0; i <= chars.length - length; i++) {
            char lastCh = chars[i + length - 1];
            cur[lastCh - 97]++;

            if (equals(fr, cur)) {
                return true;
            }

            cur[chars[i] - 97]--;
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
}
