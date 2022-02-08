package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class FindAllAnagramsInAStringSpec extends Specification {

    @Unroll
    def "should return all anagram indexes #result for text #text and search #search"() {
        expect:
        FindAllAnagramsInAString.findAnagrams(text, search) == result
        where:
        text         | search | result
        "ab"         | "ba"   | [0]
        "aba"        | "ba"   | [0, 1]
        "abab"       | "ba"   | [0, 1, 2]
        "cbaebabacd" | "abc"  | [0, 6]
    }
}
