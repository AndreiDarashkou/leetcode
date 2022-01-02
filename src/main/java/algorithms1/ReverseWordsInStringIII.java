package algorithms1;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 */
public class ReverseWordsInStringIII {

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int from = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                rotate(chars, from, i - 1);
                from = i + 1;
            }
        }
        rotate(chars, from, chars.length - 1);

        return new String(chars);
    }

    private static void rotate(char[] chars, int from, int to) {
        while (from < to) {
            char temp = chars[from];
            chars[from] = chars[to];
            chars[to] = temp;
            from++;
            to--;
        }
    }
}
