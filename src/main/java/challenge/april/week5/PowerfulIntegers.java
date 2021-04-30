package challenge.april.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3726/
 * <p>
 * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or equal to bound.
 * An integer is powerful if it can be represented as x^i + y^j for some integers i >= 0 and j >= 0.
 * You may return the answer in any order. In your answer, each value should occur at most once.
 */
public class PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        if (bound < 2) {
            return List.of();
        }
        if (x == 1 && y == 1) {
            return List.of(2);
        }
        Set<Integer> result = new TreeSet<>();
        if (x == 1) {
            for (int powY = 1; powY < bound; powY = powY * y) {
                result.add(1 + powY);
            }
        } else if (y == 1) {
            for (int powX = 1; powX < bound; powX = powX * x) {
                result.add(powX + 1);
            }
        } else {
            for (int powX = 1; powX < bound; powX = powX * x) {
                for (int powY = 1, sum = powX + 1; sum <= bound; powY = powY * y, sum = powX + powY) {
                    result.add(sum);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
