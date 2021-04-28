package challenge.april.week2;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3702/
 * <p>
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographicaly in this alien language.
 */
public class VerifyingAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (bigger(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean bigger(String word, String nextWord, String order) {
        char[] wordChars = word.toCharArray();
        char[] nextWordChars = nextWord.toCharArray();

        int min = Math.min(wordChars.length, nextWordChars.length);
        int delta;

        for (int i = 0; i < min; i++) {
            int char1 = order.indexOf(wordChars[i]);
            int char2 = order.indexOf(nextWordChars[i]);

            if ((delta = char1 - char2) != 0) {
                return delta > 0;
            }
        }

        return wordChars.length > nextWordChars.length;
    }

}
