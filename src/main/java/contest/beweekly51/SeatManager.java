package contest.beweekly51;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/contest/biweekly-contest-51/problems/seat-reservation-manager/
 */
public class SeatManager {

    private final PriorityQueue<Integer> available;

    public SeatManager(int n) {
        available = new PriorityQueue<>(n);
        for (int i = 1; i <= n; i++) {
            available.add(i);
        }
    }

    public int reserve() {
        Integer min = available.poll();
        return min == null ? -1 : min;
    }

    public void unreserve(int seatNumber) {
        available.add(seatNumber);
    }
}
