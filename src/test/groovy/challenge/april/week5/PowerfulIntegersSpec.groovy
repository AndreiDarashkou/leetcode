package challenge.april.week5

import spock.lang.Specification
import spock.lang.Unroll

class PowerfulIntegersSpec extends Specification {

    @Unroll
    def "should return #result where x #x y #y bound #bound"() {
        given:
        def algorithm = new PowerfulIntegers()
        expect:
        algorithm.powerfulIntegers(x, y, bound) == result
        where:
        x   | y   | bound   | result
        1   | 1   | 0       | []
        2   | 2   | 3       | [2, 3]
        1   | 1   | 10      | [2]
        2   | 1   | 10      | [2, 3, 5, 9]
        1   | 2   | 10      | [2, 3, 5, 9]
        2   | 3   | 10      | [2, 3, 4, 5, 7, 9, 10]
        3   | 4   | 100     | [2, 4, 5, 7, 10, 13, 17, 19, 25, 28, 31, 43, 65, 67, 73, 82, 85, 91, 97]
        100 | 100 | 1000000 | [2, 101, 200, 10001, 10100, 20000]
    }
}
