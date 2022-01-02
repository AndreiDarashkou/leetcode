package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class ReverseWordsInStringIIISpec extends Specification {

    @Unroll
    def "should reverse words in string #text"() {
        expect:
        ReverseWordsInStringIII.reverseWords(text) == reversed
        where:
        text                          | reversed
        "abc"                         | "cba"
        "mother father"               | "rehtom rehtaf"
        "Let's take LeetCode contest" | "s'teL ekat edoCteeL tsetnoc"
    }
}
