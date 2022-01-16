package algorithms1

import spock.lang.Specification

class ReverseBitsSpec extends Specification {

    def "should reverse bits for number #number to @reversed (1)"() {
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

    def "should reverse bits for number #number to @reversed (2)"() {
        expect:
        ReverseBits.reverseBits2(number) == reversed
        where:
        number    | reversed
        2         | 1073741824
        123456    | 38240256
        1000000   | 37941248
        10000000  | 23664896
        100000000 | 8892320
    }
}
