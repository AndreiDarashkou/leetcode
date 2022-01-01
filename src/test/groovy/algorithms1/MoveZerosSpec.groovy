package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class MoveZerosSpec extends Specification {

    @Unroll
    def "should move all zeros to the end for array #nums"() {
        expect:
        MoveZeroes.moveZeroes(nums as int[]) == result as int[]
        where:
        nums                  | result
        [1, 2]                | [1, 2]
        [1, 0, 2]             | [1, 2, 0]
        [0, 5, 1, 0, 0, 0, 2] | [5, 1, 2, 0, 0, 0, 0]
        [-1, -9, 9, 0, 0, 0]  | [-1, -9, 9, 0, 0, 0]
    }
}
