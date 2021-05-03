package challenge.may

import challenge.may.week1.RunningSumOf1dArray
import spock.lang.Specification
import spock.lang.Unroll

class RunningSumOf1dArraySpec extends Specification {

    @Unroll
    def "should summarize elements in array #nums"() {
        given:
        def algorithm = new RunningSumOf1dArray()
        expect:
        algorithm.runningSum(nums as int[]) == result as int[]
        where:
        nums               | result
        [1, 2, 3, 4]       | [1, 3, 6, 10]
        [1, 1, 1, 1, 1]    | [1, 2, 3, 4, 5]
        [3, 1, 2, 10, 1]   | [3, 4, 6, 16, 17]
        [8, 9, 1, 110, 99] | [8, 17, 18, 128, 227]
    }
}
