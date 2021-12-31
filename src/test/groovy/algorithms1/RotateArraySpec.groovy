package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class RotateArraySpec extends Specification {

    @Unroll
    def "should rotate1 #nums with #k to #result"() {
        expect:
        RotateArray.rotate1(nums as int[], k) == result as int[]
        where:
        nums                  | k | result
        [1, 2]                | 1 | [2, 1]
        [1, 2]                | 2 | [1, 2]
        [1, 2]                | 5 | [2, 1]
        [1, 2, 3, 4, 5, 6, 7] | 3 | [5, 6, 7, 1, 2, 3, 4]
        [-10, -6, -90, 90, 5] | 1 | [5, -10, -6, -90, 90]
    }

    @Unroll
    def "should rotate2 #nums with #k to #result"() {
        expect:
        RotateArray.rotate2(nums as int[], k) == result as int[]
        where:
        nums                  | k | result
        [1, 2]                | 1 | [2, 1]
        [1, 2]                | 2 | [1, 2]
        [1, 2]                | 5 | [2, 1]
        [1, 2, 3, 4, 5, 6, 7] | 3 | [5, 6, 7, 1, 2, 3, 4]
        [-10, -6, -90, 90, 5] | 1 | [5, -10, -6, -90, 90]
    }
}
