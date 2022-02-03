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

    //O(1) memory
    public static boolean backspaceCompare2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int sIdx = next(sChars, sChars.length);
        int tIdx = next(tChars, tChars.length);
        while (sIdx >= 0 && tIdx >= 0) {
            if (sChars[sIdx] != tChars[tIdx]) {
                return false;
            }
            sIdx = next(sChars, sIdx);
            tIdx = next(tChars, tIdx);
        }
        return sIdx == tIdx;
    }

    private static int next(char[] chars, int index) {
        int back = 0;
        index = index - 1;

        while (index >= 0) {
            if (chars[index] == '#') {
                back++;
            } else if (back > 0) {
                back--;
            } else {
                return index;
            }
            index--;
        }
        return index;
    }
}
