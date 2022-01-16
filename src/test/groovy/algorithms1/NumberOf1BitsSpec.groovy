package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class NumberOf1BitsSpec extends Specification {

    @Unroll
    def "should return number of bits #count for number #number"() {
        expect:
        NumberOf1Bits.hammingWeight(number) == count
        NumberOf1Bits.hammingWeight2(number) == count
        where:
        number | count
        1      | 1 //0001
        2      | 1 //0010
        3      | 2 //0011
        4      | 1 //0100
        5      | 2 //0101
        6      | 2 //0110
        7      | 3 //0111
        8      | 1 //1000
        128    | 1 // 1000 0000
        -3     | 31
        -1     | 32
    }
}
