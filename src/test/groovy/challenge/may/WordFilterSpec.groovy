package challenge.may

import challenge.may.week1.WordFilter
import spock.lang.Specification
import spock.lang.Unroll

class WordFilterSpec extends Specification {

    @Unroll
    def "should find last index of word with prefix #prefix and suffix #suffix"() {
        given:
        def algorithm = new WordFilter(words as String[])
        expect:
        algorithm.find(prefix, suffix) == index
        where:
        words                          | prefix | suffix | index
        ["apple", "bob", "ape", "mom"] | "ap"   | "pe"   | 2
        ["apple", "bob", "ape", "mom"] | "a"    | "e"    | 2
        ["apple", "bob", "ape", "mom"] | "ap"   | "om"   | -1
        ["apple", "bob", "ape", "mom"] | "m"    | ""     | 3
        ["apple", "bob", "ape", "mom"] | ""     | "m"    | 3
    }
}
