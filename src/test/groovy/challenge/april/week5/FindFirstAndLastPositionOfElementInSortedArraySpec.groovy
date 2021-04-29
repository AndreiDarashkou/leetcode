package challenge.april.week5

import spock.lang.Specification
import spock.lang.Unroll

class FindFirstAndLastPositionOfElementInSortedArraySpec extends Specification {

    @Unroll
    def "should return array of indexes where element #element exists"() {
        given:
        def algorithm = new FindFirstAndLastPositionOfElementInSortedArray()
        expect:
        algorithm.searchRange(nums as int[], element) == result as int[]
        where:
        nums                           | element | result
//        [1, 2, 3, 3, 4, 5]             | 2       | [1, 1]
//        [1, 2, 3, 3, 4, 5]             | 3       | [2, 3]
        [1, 2, 3, 3, 5, 6]             | 4       | [-1, -1]
//        [6, 7, 10, 10, 15]             | 5       | [-1, -1]
//        [6, 7, 10, 10, 15, 15, 15, 20] | 15      | [4, 6]
//        [5, 5, 5, 5]                   | 5       | [0, 3]
    }
}
