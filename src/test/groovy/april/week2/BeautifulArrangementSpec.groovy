package april.week2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3705/
 *
 * Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:
 *
 * Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * Return the list answer. If there multiple valid answers, return any of them.
 */
class BeautifulArrangementSpec extends Specification {

    @Unroll
    def "should return #result if n = #n and k = #k"() {
        given:
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement()
        expect:
        beautifulArrangement.constructArray(n, k) == result as int[]
        where:
        n | k | result
        2 | 1 | [1, 2]
        3 | 2 | [1, 3, 2]
        4 | 2 | [1, 2, 4, 3]
        8 | 5 | [1, 2, 3, 8, 4, 7, 5, 6]
    }
}
