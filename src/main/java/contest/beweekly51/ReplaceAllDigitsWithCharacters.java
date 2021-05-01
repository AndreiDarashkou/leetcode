package contest.beweekly51;

/**
 * https://leetcode.com/contest/biweekly-contest-51/problems/replace-all-digits-with-characters/
 */
public class ReplaceAllDigitsWithCharacters {
    private static final String REGEXP = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";

    public String replaceDigits(String text) {
        String[] slitted = text.split(REGEXP);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < slitted.length - 1; i += 2) {
            int shift = Integer.parseInt(slitted[i + 1]);
            int ch = slitted[i].charAt(0);
            result.append((char) ch).append((char) (ch + shift));
        }
        if (slitted.length % 2 != 0) {
            result.append(slitted[slitted.length - 1]);
        }

        return result.toString();
    }

}
