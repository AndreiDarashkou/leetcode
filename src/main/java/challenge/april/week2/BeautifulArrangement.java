package challenge.april.week2;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3705/
 * <p>
 * Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:
 * <p>
 * Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * Return the list answer. If there multiple valid answers, return any of them.
 */
public class BeautifulArrangement {

    public int[] constructArray(int n, int k) {
        int size = n;
        int[] result = new int[size];

        for (int index = 0, val = 1; val <= n; index++) {
            if (index == size - k) {
                result[index] = n--;
                k -= 2;
            } else {
                result[index] = val++;
            }
        }
        return result;
    }

}
