package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class PermutationInStringSpec extends Specification {

    @Unroll
    def "should check existence of substring #sub in #str and return #result (1)"() {
        expect:
        PermutationInString.checkInclusion(sub, str) == result
        where:
        str                    | sub     | result
        "mama"                 | "am"    | true
        "xxxcbaxxx"            | "abc"   | true
        "thereisaverylongtext" | "nogly" | true
        "thereisaverylongtext" | "nogle" | false
        "dcda"                 | "adc"   | true
    }


    @Unroll
    def "should check existence of substring #sub in #str and return #result (2)"() {
        expect:
        PermutationInString.checkInclusion2(sub, str) == result
        where:
        str                    | sub     | result
        "mama"                 | "am"    | true
        "xxxcbaxxx"            | "abc"   | true
        "thereisaverylongtext" | "nogly" | true
        "thereisaverylongtext" | "nogle" | false
        "dcda"                 | "adc"   | true
    }
}
