package challenge.may.week1

import spock.lang.Specification
import spock.lang.Unroll

class JumpGameIISpec extends Specification {

    @Unroll
    def "should return min jumps #jumps for steps #steps"() {
        given:
        def algorithm = new JumpGameII()
        expect:
        algorithm.jump(steps as int[]) == jumps
        where:
        steps                                                                     | jumps
        [2, 3, 1, 4, 1, 1, 1, 3]                                                  | 3
        [2, 3, 1, 1, 4]                                                           | 2
        [2, 3, 0, 1, 4]                                                           | 2
        [2, 3, 0, 1, 4, 1, 1, 3, 1, 4, 8, 10, 1, 5, 6, 0, 0, 6, 5, 5, 1, 1, 1, 1] | 6
        [7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3]                             | 2
    }
}