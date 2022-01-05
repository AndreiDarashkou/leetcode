package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class LongestSubstringWithoutRepeatingCharactersSpec extends Specification {

    @Unroll
    def "should return length #length of longest unique substring from #str (1)"() {
        expect:
        LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str) == length
        where:
        str            | length
        "mama"         | 2
        "abcdefcpoqwq" | 8
        "bbbbbb"       | 1
    }

    @Unroll
    def "should return length #length of longest unique substring from #str (2)"() {
        expect:
        LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2(str) == length
        where:
        str            | length
        "mama"         | 2
        "abcdefcpoqwq" | 8
        "bbbbbb"       | 1
    }
}
