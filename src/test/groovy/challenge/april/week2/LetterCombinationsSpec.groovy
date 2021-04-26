package challenge.april.week2

import spock.lang.Specification
import spock.lang.Unroll

class LetterCombinationsSpec extends Specification {

    @Unroll
    def "should return all possible text combinations for letters #letters"() {
        given:
        def combinations = new LetterCombinations()
        expect:
        combinations.letterCombinations(letters) == result
        where:
        letters | result
        "234"   | ["adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi", "beg", "beh",
                   "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei", "cfg", "cfh", "cfi"]
        "84"    | ["sg", "sh", "si", "tg", "th", "ti", "ug", "uh", "ui"]
    }
}
