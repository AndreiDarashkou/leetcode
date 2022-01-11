package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class HouseRobberSpec extends Specification {

    @Unroll
    def "should return max #max money robbed from houses #houses"() {
        expect:
        HouseRobber.rob(houses as int[]) == max
        where:
        houses                | max
        [1, 3, 1]             | 3
        [1, 2]                | 2
        [1, 2, 2]             | 3
        [2, 1, 5, 7]          | 9
        [2, 7, 9, 3, 1]       | 12
        []                    | 0
        [2, 1, 1, 2]          | 4
        [4, 1, 2, 7, 5, 3, 1] | 14
    }
}
