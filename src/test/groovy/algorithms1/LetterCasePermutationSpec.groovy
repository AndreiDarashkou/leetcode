package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class LetterCasePermutationSpec extends Specification {

    @Unroll
    def "should permute all letters for srt #str"() {
        expect:
        LetterCasePermutation.letterCasePermutation(str) == permutations
        where:
        str     | permutations
        '1'     | ['1']
        'C'     | ['C', 'c']
        "ab"    | ['ab', 'aB', 'AB', 'Ab']
        "a1b"   | ['a1b', 'a1B', 'A1B', 'A1b']
        "a1b2c" | ['a1b2c', 'a1b2C', 'a1B2C', 'a1B2c', 'A1B2c', 'A1B2C', 'A1b2C', 'A1b2c']
    }
}
