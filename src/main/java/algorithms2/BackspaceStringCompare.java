package algorithms2;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        return getStr(s).equals(getStr(t));
    }

    private static String getStr(String str) {
        StringBuilder result = new StringBuilder();

        char[] chars = str.toCharArray();
        int index = chars.length - 1;
        int back = 0;

        while (index >= 0) {
            if (chars[index] == '#') {
                back++;
            } else if (back > 0) {
                back--;
            } else {
                result.append(chars[index]);
            }
            index--;
        }
        return result.toString();
    }
}
