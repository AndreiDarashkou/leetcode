package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class ReverseStringSpec extends Specification {

    @Unroll
    def "should reverse string 1 chars #chars (1)"() {
        expect:
        ReverseString.reverseString1(chars.toCharArray()) == reversed.toCharArray()
        where:
        chars        | reversed
        "abc"        | "cba"
        "mother"     | "rehtom"
        "a a a a a"  | "a a a a a"
        " a a a a a" | "a a a a a "
    }

    @Unroll
    def "should reverse string chars #chars (2)"() {
        expect:
        ReverseString.reverseString2(chars.toCharArray()) == reversed.toCharArray()
        where:
        chars        | reversed
        "abc"        | "cba"
        "mother"     | "rehtom"
        "a a a a a"  | "a a a a a"
        " a a a a a" | "a a a a a "
    }
}
