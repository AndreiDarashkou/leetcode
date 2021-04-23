package com.home.challenge.april;

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
