package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class FindFirstAndLastPositionOfElementInSortedArraySpec extends Specification {

    @Unroll
    def "should find first and last indexes of element #target and return #pos"() {
        expect:
        FindFirstAndLastPositionOfElementInSortedArray.searchRange(nums as int[], target) == pos as int[]
        where:
        nums                     | target | pos
        [1, 2, 2, 3]             | 2      | [1, 2]
        [1, 2, 2, 3]             | 3      | [3, 3]
        [1, 2, 2, 3]             | 1      | [0, 0]
        [1, 2, 2, 3]             | 4      | [-1, -1]
        [1, 2, 2, 3, 3, 3, 3, 9] | 3      | [3, 6]
    }
}
