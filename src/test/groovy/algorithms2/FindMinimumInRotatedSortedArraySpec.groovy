package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class FindMinimumInRotatedSortedArraySpec extends Specification {

    @Unroll
    def "should find min element #result in array #nums"() {
        expect:
        FindMinimumInRotatedSortedArray.findMin(nums as int[]) == result
        where:
        nums                     | result
        [4, 5, 6, 1, 2, 3]       | 1
        [4, 5, 6, 9, 0, 1, 2, 3] | 0
        [1, 2, 3, 4]             | 1
        [2, 3, 4, 1]             | 1
    }
}
