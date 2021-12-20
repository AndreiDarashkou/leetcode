package test;

/*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabcava"));
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

//    public static int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        int max = 0;
//        int current = 0;
//        Map<Character, Integer> unique = new HashMap<>();
//        for (int i = 0; i < chars.length; i++) {
//            char ch = chars[i];
//            Integer prev = unique.put(ch, i);
//            if (prev != null) {
//                max = Math.max(current, max);
//                unique.values().removeIf(v -> v < prev);
//                current = i - prev;
//            } else {
//                current++;
//            }
//        }
//        return Math.max(current, max);
//    }

}
