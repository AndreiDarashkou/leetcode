package medium

import spock.lang.Specification
import spock.lang.Unroll

class Pattern132Spec extends Specification {

    @Unroll
    def "should find 132 pattern using stack for nums #nums"() {
        expect:
        Pattern132.find132pattern(nums as int[]) == result
        where:
        nums                           | result
        [3, 8, 4, 1, 2, 3, 6, 5, 4, 7] | true
        [1, 3, 2]                                                          | true
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2] | true
        [1, 0, 2, 3, 2]                                                    | true
        [15, 11, 11, 12, 14, 8, 7, 6, 8, 7]                                | true
        [1, 2, 3, 4]                                                       | false
        [4, 3, 2, 1]                                                       | false
        [1, 2, 1, 4, 1]                                                    | false
        [5, 4, 5, 0, 1]                                                    | false
        [3, 5, 0, 3, 4]                                                    | true //3,5,x,x,4 ~ 1,3,2
        [2, 4, 3, 1]                                                       | true
    }

    @Unroll
    def "should find 132 pattern using stack for nums #nums using stack"() {
        expect:
        Pattern132.find132patternViaStack(nums as int[]) == result
        where:
        nums                                                               | result
        [1, 3, 2]                                                          | true
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2] | true
        [1, 0, 2, 3, 2]                                                    | true
        [15, 11, 11, 12, 14, 8, 7, 6, 8, 7]                                | true
        [1, 2, 3, 4]                                                       | false
        [4, 3, 2, 1]                                                       | false
        [1, 2, 1, 4, 1]                                                    | false
        [5, 4, 5, 0, 1]                                                    | false
        [3, 5, 0, 3, 4]                                                    | true //3,5,x,x,4 ~ 1,3,2
    }

    @Unroll
    def "should find 132 pattern using brute force for nums #nums"() {
        expect:
        Pattern132.find132patternBruteForce(nums as int[]) == result
        where:
        nums                                                               | result
        [1, 3, 2]                                                          | true
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2] | true
        [1, 0, 2, 3, 2]                                                    | true
        [15, 11, 11, 12, 14, 8, 7, 6, 8, 7]                                | true
        [1, 2, 3, 4]                                                       | false
        [4, 3, 2, 1]                                                       | false
        [1, 2, 1, 4, 1]                                                    | false
        [5, 4, 5, 0, 1]                                                    | false
        [3, 5, 0, 3, 4]                                                    | true //3,5,x,x,4 ~ 1,3,2
    }
}
