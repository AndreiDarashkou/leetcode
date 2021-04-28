package challenge.april.week3;

import static java.util.stream.Collectors.joining;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3710/
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
