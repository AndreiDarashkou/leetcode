package challenge.april.week4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/
 * <p>
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have
 * the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 */
public class BrickWall {

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
}
