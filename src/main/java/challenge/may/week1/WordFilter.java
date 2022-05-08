package challenge.may.week1;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3728/
 */
public class WordFilter {

    private static final int MAX_PREFIX_LENGTH = 10;
    private final TreeMap<String, Integer> map = new TreeMap<>();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
    }

    public int find(String prefix, String suffix) {
        String toPrefix = prefix + "z".repeat(MAX_PREFIX_LENGTH - prefix.length());

        return map.subMap(prefix, true, toPrefix, true).entrySet()
                .stream()
                .filter(e -> e.getKey().endsWith(suffix))
                .map(Map.Entry::getValue)
                .max(Comparator.naturalOrder()).orElse(-1);
    }
}
