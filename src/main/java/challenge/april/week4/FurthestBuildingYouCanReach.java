package challenge.april.week4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3721/
 * <p>
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * <p>
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 * <p>
 * While moving from building i to building i+1 (0-indexed),
 * <p>
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 */
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int furthest = 0;

        for (; furthest < heights.length - 1; furthest++) {
            int delta = heights[furthest + 1] - heights[furthest];
            if (delta <= 0) {
                continue;
            }
            if (delta > bricks && ladders == 0) {
                break;
            }
            if (bricks >= delta) {
                bricks -= delta;
                queue.add(delta);
                continue;
            }
            Integer biggestDelta = queue.peek();
            if (biggestDelta != null && biggestDelta > delta) {
                queue.remove();
                queue.add(delta);
                bricks += (biggestDelta - delta);
            }
            ladders--;
        }
        return furthest;
    }
}
