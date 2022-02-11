package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class SubarrayProductLessThanKSpec extends Specification {

    @Unroll
    def "should return amount of subarrays #count product less than #product"() {
        expect:
        SubarrayProductLessThanK.numSubarrayProductLessThanK(nums as int[], product) == count
        where:
        nums      | product | count
        [1]       | 1       | 0
        [1, 2]    | 2       | 1
        [1, 2, 3] | 6       | 5
        [1, 2, 3] | 7       | 7
    }
}
