package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class SquaresOfSortedArraySpec extends Specification {

    @Unroll
    def "should sort array #nums and return #result"() {
        expect:
        SquaresOfSortedArray.sortedSquares(nums as int[]) == result as int[]
        where:
        nums                | result
        [1, 2]              | [1, 4]
        [-2, 2]             | [4, 4]
        [-9, -5, -3, 1, 10] | [1, 9, 25, 81, 100]
        [-10, -9, -5]       | [25, 81, 100]
    }

}
