package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class BackspaceStringCompareSpec extends Specification {

    @Unroll
    def "should compare two strings #s and #t and return #result"() {
        expect:
        BackspaceStringCompare.backspaceCompare(s, t) == result
        where:
        s          | t      | result
        "a"        | "a"    | true
        "b#"       | "a#"   | true
        "c#"       | "a#b#" | true
        "ac##b"    | "b"    | true
        "abcd####" | ""     | true
    }
}
