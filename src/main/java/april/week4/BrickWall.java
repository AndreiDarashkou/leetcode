package april.week4;

import java.util.*;

public class BrickWall {

    public static void main(String[] args) {
        System.out.println(leastBricks(list(list(1), list(1), list(1))));
        System.out.println(leastBricks(list(list(1, 1), list(2), list(1, 1))));
        System.out.println(leastBricks(list(list(1, 2, 2, 1), list(3, 1, 2), list(1, 3, 2), list(2, 4), list(3, 1, 2), list(1, 3, 1, 1))));
    }

    public static int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> equalSizeMap = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                if (equalSizeMap.containsKey(sum)) {
                    equalSizeMap.put(sum, equalSizeMap.get(sum) + 1);
                } else {
                    equalSizeMap.put(sum, 1);
                }
            }
        }

        int max = 0;
        for (Integer val : equalSizeMap.values()) {
            if (val > max) {
                max = val;
            }
        }

        return wall.size() - max;
    }

    public static int leastBricks2(List<List<Integer>> wall) {
        for (List<Integer> list : wall) {
            if (list.size() == 1) {
                continue;
            }
            for (int i = 1; i < list.size(); i++) {
                list.set(i, list.get(i - 1) + list.get(i));
            }
        }

        Map<Integer, Integer> equalSizeMap = new HashMap<>();
        for (List<Integer> list : wall) {
            for (int i = 0; i < list.size() - 1; i++) {
                int val = list.get(i);
                if (equalSizeMap.containsKey(val)) {
                    equalSizeMap.put(val, equalSizeMap.get(val) + 1);
                } else {
                    equalSizeMap.put(val, 1);
                }
            }
        }

        int max = 0;
        for (Integer val : equalSizeMap.values()) {
            if (val > max) {
                max = val;
            }
        }

        return wall.size() - max;
    }

    private static <T> List<T> list(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);

        return list;
    }

}
