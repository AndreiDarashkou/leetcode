package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class SearchInRotatedSortedArraySpec extends Specification {

    @Unroll
    def "should find return index #index for #target in array #nums"() {
        expect:
        SearchInRotatedSortedArray.search(nums as int[], target) == index
        where:
        nums            | target | index
        [1, 2, 3]       | 1      | 0
        [1, 2, 3]       | 2      | 1
        [1, 2, 3]       | 3      | 2
        [1, 2, 3]       | -1     | -1
        [1, 2, 3]       | 4      | -1
        [1, 2]          | 1      | 0
        [1, 2]          | 2      | 1
        [1, 2]          | 0      | -1
        [1, 2]          | 3      | -1
        [2, 3, 4, 1]    | 2      | 0
        [2, 3, 4, 1]    | 1      | 3
        [2, 3, 4, 1]    | 3      | 1
        [2, 3, 4, 1]    | 5      | -1
        [2, 3, 4, 1]    | 0      | -1
        [2, 3, 5, 1]    | 4      | -1
        [2, 3, 4, 5, 1] | 2      | 0
        [2, 3, 4, 5, 1] | 1      | 4
        [2, 3, 4, 5, 1] | 3      | 1
        [3, 4, 5, 1, 2] | 5      | 2
        [3, 4, 5, 1, 2] | 0      | -1
        [3, 5, 6, 1, 2] | 4      | -1
    }
}
