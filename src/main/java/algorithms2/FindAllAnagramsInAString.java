package algorithms2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String text, String search) {
        if (text.length() < search.length()) {
            return Collections.emptyList();
        }

        byte[] mask = new byte[26];
        for (char ch : search.toCharArray()) {
            mask[ch - 97]++;
        }

        char[] chars = text.toCharArray();
        byte[] current = new byte[26];
        for (int idx = 0; idx < search.length() - 1; idx++) {
            current[chars[idx] - 97]++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= text.length() - search.length(); i++) {
            char lastCh = chars[i + search.length() - 1];
            current[lastCh - 97]++;

            if (isEqual(mask, current)) {
                result.add(i);
            }
            current[chars[i] - 97]--;
        }

        return result;
    }

    private static boolean isEqual(byte[] mask, byte[] current) {
        for (int i = 0; i < 26; i++) {
            if (mask[i] != current[i]) {
                return false;
            }
        }
        return true;
    }
}
