package com.home.challenge.april;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class LetterCombinations {

    private static final Map<Integer, List<String>> CODES_MAP = Map.of(
            (int) '2', List.of("a", "b", "c"),
            (int) '3', List.of("d", "e", "f"),
            (int) '4', List.of("g", "h", "i"),
            (int) '5', List.of("j", "k", "l"),
            (int) '6', List.of("m", "n", "o"),
            (int) '7', List.of("p", "q", "r"),
            (int) '8', List.of("s", "t", "u"),
            (int) '9', List.of("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return List.of();
        }
        List<List<String>> codesLists = digits.chars().mapToObj(CODES_MAP::get).collect(toList());

        List<String> combinations = codesLists.get(0);
        for (int i = 1; i < codesLists.size(); i++) {
            combinations = interpolation(combinations, codesLists.get(i));
        }
        return combinations;
    }

    private List<String> interpolation(List<String> codes1, List<String> codes2) {
        List<String> result = new ArrayList<>(codes1.size() * codes2.size());
        for (String code1 : codes1) {
            for (String code2 : codes2) {
                result.add(code1 + code2);
            }
        }
        return result;
    }

}
