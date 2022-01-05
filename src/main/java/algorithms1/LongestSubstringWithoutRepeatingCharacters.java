package algorithms1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("aabcava"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        int longest = 0;
        int currentLength = 0;
        int startLengthIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            currentLength++;

            for (int j = startLengthIndex; j < i; j++) {
                if (chars[j] == chars[i]) {
                    longest = Math.max(currentLength - 1, longest);
                    currentLength = i - j;
                    startLengthIndex = j + 1;
                    break;
                }
            }
        }
        return Math.max(currentLength, longest);
    }

    public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int current = 0;
        Map<Character, Integer> unique = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            Integer prev = unique.put(ch, i);
            if (prev != null) {
                max = Math.max(current, max);
                unique.values().removeIf(v -> v < prev);
                current = i - prev;
            } else {
                current++;
            }
        }
        return Math.max(current, max);
    }

}
