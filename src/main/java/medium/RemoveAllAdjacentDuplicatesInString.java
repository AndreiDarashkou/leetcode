package medium;

import static java.util.stream.Collectors.joining;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String str, int k) {
        String regexp = str.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .map(c ->  new String(new char[k]).replace('\0', c))
                .collect(joining("|"));

        return removeDuplicates(str, regexp);
    }

    private String removeDuplicates(String str, String regexp) {
        String result = str.replaceAll(regexp, "");
        if (str.length() != result.length()) {
            return removeDuplicates(result, regexp);
        }

        return result;
    }
}
