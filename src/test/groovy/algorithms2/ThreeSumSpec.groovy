package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class ThreeSumSpec extends Specification {

    @Unroll
    def "should find"() {
        expect:
        ThreeSum.threeSum(nums as int[]) == result
        where:
        nums              | result
        [-1, 0, 1]        | [[-1, 0, 1]]
        [-1, 0, 1, 2, -1] | [[-1, -1, 2], [-1, 0, 1]]
        [0, 0, 0, 0]      | [[0, 0, 0]]
        [-1, 0, 1, 0]     | [[-1, 0, 1]]
        [1, -1, -1, 0]    | [[-1, 0, 1]]
    }
}