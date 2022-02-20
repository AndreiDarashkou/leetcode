package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class MinimumSizeSubarraySumSpec extends Specification {

    @Unroll
    def "should return min length #subarrayLength which elements sum >= #target"() {
        expect:
        MinimumSizeSubarraySum.minSubArrayLen(target, nums as int[]) == subarrayLength
        where:
        target | nums                                           | subarrayLength
        4      | [1, 2, 3, 4]                                   | 1
        5      | [1, 2, 1, 2, 3]                                | 2
        11     | [1, 1, 1, 5, 3, 1, 2, 1]                       | 4
        15     | [1, 2, 3, 4, 5]                                | 5
        15     | [1, 1, 1, 1, 1, 1, 1, 1]                       | 0
        213    | [12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12] | 8
        7      | [2, 3, 1, 2, 4, 3]                             | 2
    }
}
