package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class TwoSum2InputArrayIsSortedSpec extends Specification {

    @Unroll
    def "should find all zeros to the end for array #nums"() {
        expect:
        TwoSum2InputArrayIsSorted.twoSum1(nums as int[], sum) == result as int[]
        where:
        nums                     | sum | result
        [1, 2]                   | 3   | [1, 2]
        [2, 4, 5, 6, 9, 11, 19]  | 7   | [1, 3]
        [5, 8, 8, 9, 18, 19, 45] | 28  | [4, 6]
        [2, 7, 11, 15]           | 9   | [1, 2]
        [-1000, -1, 0, 1]        | 1   | [3, 4]
    }

    @Unroll
    def "should find all zeros to the end for array #nums second variant"() {
        expect:
        TwoSum2InputArrayIsSorted.twoSum2(nums as int[], sum) == result as int[]
        where:
        nums                     | sum | result
        [1, 2]                   | 3   | [1, 2]
        [2, 4, 5, 6, 9, 11, 19]  | 7   | [1, 3]
        [5, 8, 8, 9, 18, 19, 45] | 28  | [4, 6]
        [2, 7, 11, 15]           | 9   | [1, 2]
        [-1000, -1, 0, 1]        | 1   | [3, 4]
    }
}
