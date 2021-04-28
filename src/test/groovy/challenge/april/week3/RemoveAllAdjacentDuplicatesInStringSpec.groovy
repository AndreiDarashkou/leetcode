package challenge.april.week3

import spock.lang.Specification
import spock.lang.Unroll

class RemoveAllAdjacentDuplicatesInStringSpec extends Specification {

    @Unroll
    def "should remove all adjacent duplicated symbols from #word"() {
        expect:
        new RemoveAllAdjacentDuplicatesInString().removeDuplicates(word, count) == result
        where:
        word                   | count | result
        "pbbcggttciiippooaais" | 2     | "ps"
        "deeedbbcccbdaa"       | 3     | "aa"
        "aabbccddeefffedcbba"  | 3     | "aaba"
    }

    @Unroll
    def "should remove all adjacent duplicated symbols from #word (second approach)"() {
        expect:
        new RemoveAllAdjacentDuplicatesInString2().removeDuplicates(word, count) == result
        where:
        word                   | count | result
        "pbbcggttciiippooaais" | 2     | "ps"
        "deeedbbcccbdaa"       | 3     | "aa"
        "aabbccddeefffedcbba"  | 3     | "aaba"
    }
}
