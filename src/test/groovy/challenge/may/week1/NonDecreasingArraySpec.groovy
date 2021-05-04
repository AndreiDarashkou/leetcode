package challenge.may.week1

import spock.lang.Specification
import spock.lang.Unroll

class NonDecreasingArraySpec extends Specification {

    @Unroll
    def "should check if array #nums can be fixed"() {
        given:
        def algorithm = new NonDecreasingArray()
        expect:
        algorithm.checkPossibility(nums as int[]) == result
        where:
        nums                  | result
        [5, 7, 1]             | true
        [5, 7, 1, 8]          | true
        [3, 1, 2]             | true
        [1, 3, 5, 3]          | true
        [1, 2, 3, 4, 3, 7, 1] | false
        [3, 4, 2, 3]          | false
        [1, 3, 2, 4, 5, 6]    | true
        [-1, 4, 2, 3,]        | true
    }
}