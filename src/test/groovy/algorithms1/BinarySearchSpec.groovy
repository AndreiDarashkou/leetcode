package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchSpec extends Specification {

    @Unroll
    def "should return index #index for #k element in #nums"() {
        expect:
        BinarySearch.search(nums as int[], k) == index
        where:
        nums                  | k | index
        [1, 2]                | 1 | 0
        [1, 2, 3, 4, 5, 6, 7] | 3 | 2
        [-10, -6, 9, 9, 15]   | 9 | 2
        [-1, 0, 1, 5]         | 9 | -1
    }

}
