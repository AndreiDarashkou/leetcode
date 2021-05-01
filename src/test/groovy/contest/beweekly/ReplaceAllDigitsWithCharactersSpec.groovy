package contest.beweekly

import contest.beweekly51.ReplaceAllDigitsWithCharacters
import spock.lang.Specification
import spock.lang.Unroll

class ReplaceAllDigitsWithCharactersSpec extends Specification {

    @Unroll
    def "should replace all digits in #str"() {
        given:
        def algorithm = new ReplaceAllDigitsWithCharacters()
        expect:
        algorithm.replaceDigits(str) == result
        where:
        str          | result
        "a1c1e1"     | "abcdef"
        "a1b2c3d4e"  | "abbdcfdhe"
        "a20c8z0v1"  | "auckzzvw"
        "a20c8z0v1a" | "auckzzvwa"
    }
}
