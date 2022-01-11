package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class TriangleSpec extends Specification {

    @Unroll
    def "should find min #min way to bottom of the tree"() {
        expect:
        Triangle.minimumTotal(triangle) == min
        where:
        triangle                   | min
        [[1]]                      | 1
        [[1], [1, 2]]              | 2  //1->1
        [[1], [1, 2], [5, 4, 3]]   | 6  //1->2->3
        [[0], [-1, 1], [1, -1, 1]] | -2 //0->-1->-1
    }

}
