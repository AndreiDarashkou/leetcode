package medium

import medium.RemoveAllAdjacentDuplicatesInString
import medium.RemoveAllAdjacentDuplicatesInString2
import spock.lang.Specification
import spock.lang.Unroll

class RemoveAllAdjacentDuplicatesInStringSpec extends Specification {

    @Unroll
    def "should remove all adjacent duplicated symbols from #word"() {
        expect:
        new RemoveAllAdjacentDuplicatesInString().removeDuplicates(word, count) == result
        where:
        word                   | count | result
        "aa"                   | 2     | ""
        "aba"                  | 2     | "aba"
        "abbaa"                | 2     | "a"
        "abbaaa"               | 2     | ""
        "abaabc"               | 2     | "ac"
        "abccbba"              | 3     | "abccbba"
        "abcccbba"             | 3     | "aa"
        "deeedbbcccbdaa"       | 3     | "aa"
        "pbbcggttciiippooaais" | 2     | "ps"
        "abcd"                 | 2     | "abcd"
        "aabbccddeefffedcbba"  | 3     | "aaba"
    }

    @Unroll
    def "should remove all adjacent duplicated symbols from #word (second approach)"() {
        expect:
        new RemoveAllAdjacentDuplicatesInString2().removeDuplicates(word, count) == result
        where:
        word                   | count | result
        "aa"                   | 2     | ""
        "aba"                  | 2     | "aba"
        "abbaa"                | 2     | "a"
        "abbaaa"               | 2     | ""
        "abaabc"               | 2     | "ac"
        "abccbba"              | 3     | "abccbba"
        "abcccbba"             | 3     | "aa"
        "deeedbbcccbdaa"       | 3     | "aa"
        "pbbcggttciiippooaais" | 2     | "ps"
        "abcd"                 | 2     | "abcd"
        "aabbccddeefffedcbba"  | 3     | "aaba"
    }
}
