package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class ClimbingStairsSpec extends Specification {

    @Unroll
    def "should return ways #ways to reach #n stair step"() {
        expect:
        ClimbingStairs.climbStairs(n) == ways
        where:
        n  | ways
        5  | 8
        7  | 21
        11 | 144
    }
}
