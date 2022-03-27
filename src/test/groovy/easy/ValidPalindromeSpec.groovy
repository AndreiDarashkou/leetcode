package easy

import spock.lang.Specification
import spock.lang.Unroll

class ValidPalindromeSpec extends Specification {

    @Unroll
    def "should verify #text is palindrome #isPalindrome"() {
        expect:
        ValidPalindrome.isPalindrome(text) == isPalindrome
        where:
        text                             | isPalindrome
        "adda"                           | true
        "abcba"                          | true
        "bbb"                            | true
        "123421"                         | false
        ""                               | true
        "q"                              | true
        "q_q"                            | true
        "A man, a plan, a canal: Panama" | true
        "0P"                             | false
        "1b1"                            | true
    }
}
