package challenge.april.week4

import spock.lang.Specification
import spock.lang.Unroll

class CountBinarySubstringsSpec extends Specification {

    @Unroll
    def "should return #result where str = #binaryStr"() {
        given:
        CountBinarySubstrings binarySubstrings = new CountBinarySubstrings();
        expect:
        binarySubstrings.countBinarySubstrings(binaryStr) == result
        where:
        binaryStr   | result
        "110000011" | 4
        "1100"      | 2
        "11100"     | 2
        "11000"     | 2
        "10101"     | 4
        "00110011"  | 6
    }

}
