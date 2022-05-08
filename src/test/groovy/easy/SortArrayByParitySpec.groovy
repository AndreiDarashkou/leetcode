package easy


import spock.lang.Specification
import spock.lang.Unroll

class SortArrayByParitySpec extends Specification {

    @Unroll
    def "should sort by odd/even and get #sorted"() {
        expect:
        SortArrayByParity.sortArrayByParity(unsorted as int[]) == sorted as int[]
        where:
        unsorted                                     | sorted
        [3, 1, 2, 4]                                 | [4, 2, 1, 3]
        [1, 2, 3, 4]                                 | [4, 2, 3, 1]
        [1, 3, 4, 5, 2, 8, 11, 23, 14, 14, 10, 0, 5] | [0, 10, 4, 14, 2, 8, 14, 23, 11, 5, 3, 1, 5]
    }
}
