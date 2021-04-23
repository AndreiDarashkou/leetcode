package com.home.challenge.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {

        System.out.println(minimumTotal(list(list(2), list(3, 4), list(6, 5, 7), list(4, 1, 8, 3))));
        System.out.println(minimumTotal(list(list(-100))));
        System.out.println(minimumTotal(list(list())));
    }

    private static <T> List<T> list(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);

        return list;
    }

    public static int minimumTotal(List<List<Integer>> lists) {

        for (int i = 1; i < lists.size(); i++) {
            lists.get(i).set(0, lists.get(i).get(0) + lists.get(i - 1).get(0)); // j == 0

            for (int j = 1; j < i; j++) {
                int min = Math.min(lists.get(i - 1).get(j - 1), lists.get(i - 1).get(j));
                lists.get(i).set(j, lists.get(i).get(j) + min);
            }

            lists.get(i).set(i, lists.get(i).get(i) + lists.get(i - 1).get(i - 1)); // j == last element
        }

        return lists.get(lists.size() - 1).stream().min(Integer::compareTo).orElse(0);
    }

}
