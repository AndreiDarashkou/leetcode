package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class SingleNumberSpec extends Specification {

    @Unroll
    def "should find non duplicated number #number from array #numbers"() {
        expect:
        SingleNumber.singleNumber(numbers as int[]) == number
        where:
        numbers               | number
        [1, 1, 3, 2, 3]       | 2
        [1, 5, 3, 5, 3]       | 1
        [7, 7, 3, 8, 3, 4, 8] | 4
    }
}
