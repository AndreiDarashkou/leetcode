package challenge.april.week2

import spock.lang.Specification
import spock.lang.Unroll

class VerifyingAlienDictionarySpec extends Specification {

    @Unroll
    def "should return ordered: #result of words when words: #words and order: #order"() {
        given:
        VerifyingAlienDictionary dictionary = new VerifyingAlienDictionary()
        expect:
        dictionary.isAlienSorted(words as String[], order) == result
        where:
        words                    | order                        | result
        ["asd"]                  | "abcdefghijklmnopqrstuvwxyz" | true
        ["aaa", "bbb", "caa"]    | "abcdefghijklmnopqrstuvwxyz" | true
        ["asd", "baa"]           | "abcdefghijklmnopqrstuvwxyz" | true
        ["abc", "abcc"]          | "abcdefghijklmnopqrstuvwxyz" | true
        ["abcc", "abc"]          | "abcdefghijklmnopqrstuvwxyz" | false
        ["tonny", "web"]         | "atcdefwhijklmnopqrsbuvgxyz" | true
        ["web", "tonny"]         | "atcdefwhijklmnopqrsbuvgxyz" | false
        ["word", "world", "row"] | "worldabcefghijkmnpqstuvxyz" | false
    }
}