package algorithms1

import spock.lang.Specification

class ReverseBitsSpec extends Specification {

    def "should reverse bits for number #number to @reversed"() {
        expect:
        ReverseBits.reverseBits(number) == reversed
        where:
        number    | reversed
        2         | 1073741824
        123456    | 38240256
        1000000   | 37941248
        10000000  | 23664896
        100000000 | 8892320
    }
}
