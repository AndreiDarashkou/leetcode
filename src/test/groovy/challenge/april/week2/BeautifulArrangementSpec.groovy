package challenge.april.week2

import spock.lang.Specification
import spock.lang.Unroll

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
