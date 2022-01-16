package algorithms1

import spock.lang.Specification

class PowerOfTwoSpec extends Specification {

    def "should return #result if number is #number (1)"() {
        expect:
        PowerOfTwo.isPowerOfTwo(number) == result
        where:
        number | result
        4      | true
        256    | true
        64     | true
        0      | false
        -1     | false
        17     | false
    }

    def "should return #result if number is #number (2)"() {
        expect:
        PowerOfTwo.isPowerOfTwo2(number) == result
        where:
        number | result
        4      | true
        256    | true
        64     | true
        0      | false
        -1     | false
        17     | false
    }

    def "should return #result if number is #number (3)"() {
        expect:
        PowerOfTwo.isPowerOfTwo3(number) == result
        where:
        number | result
        4      | true
        256    | true
        64     | true
        0      | false
        -1     | false
        17     | false
    }
}
