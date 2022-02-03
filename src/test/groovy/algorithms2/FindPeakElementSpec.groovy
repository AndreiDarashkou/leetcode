package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class FindPeakElementSpec extends Specification {

    @Unroll
    def "should find first peak element index #peakIndex in array #nums"() {
        expect:
        FindPeakElement.findPeakElement(nums as int[]) == peakIndex
        where:
        nums                     | peakIndex
        [4]                      | 0
        [2, 9]                   | 1
        [8, 1]                   | 0
        [1, 2, 3, 1]             | 2
        [1, 2, 1]                | 1
        [3, 5, 4, 3, 2, 5, 8, 5] | 1
        [3, 2, 1]                | 0
    }
}
