package medium;


/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3710/
 *
 * The second approach.
 */
public class RemoveAllAdjacentDuplicatesInString2 {

    public String removeDuplicates(String str, int k) {
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];

        int duplicates = 0;
        char prev = chars[0];

        for (int i = 0, n = 0; i < chars.length; i++) {
            char current = chars[i];
            if (prev == current) {
                duplicates++;
            } else {
                duplicates = 1;
            }
            prev = current;
            if (duplicates == k) {
                for (int j = n - k + 1; j < n; j++) {
                    result[j] = '\0';
                }
                n = n - k + 1;
                if (n > 0) {
                    prev = result[n - 1];
                    duplicates = 0;
                    for (int z = n - 1; z >= 0; z--) {
                        if (result[z] == prev) {
                            duplicates++;
                        } else {
                            break;
                        }
                    }
                } else {
                    prev = '\0';
                    duplicates = 1;
                }
            } else {
                result[n++] = current;
            }
        }

        return new String(result).trim();
    }
}
