package challenge.april.week4;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/
 * <p>
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String str) {
        char[] chars = str.toCharArray();
        if (chars.length < 2) {
            return 0;
        }

        int prev = 0;
        int current = 1;
        int resultCount = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                current++;
            } else {
                resultCount += Math.min(current, prev);
                prev = current;
                current = 1;
            }
        }
        resultCount += Math.min(current, prev);

        return resultCount;
    }

}
