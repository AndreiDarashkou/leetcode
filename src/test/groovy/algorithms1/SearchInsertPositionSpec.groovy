package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class SearchInsertPositionSpec extends Specification {

    @Unroll
    def "should return index #insertPosition for #k element for #nums"() {
        expect:
        SearchInsertPosition.searchInsert(nums as int[], k) == insertPosition
        where:
        nums                    | k    | insertPosition
        [-100, -50, 0, 50, 100] | -125 | 0
        [-100, -50, 0, 50, 100] | -75  | 1
        [-100, -50, 0, 50, 100] | 0    | 2
        [-100, -50, 0, 50, 100] | 75   | 4
        [-100, -50, 0, 50, 100] | 125  | 5
    }
}
