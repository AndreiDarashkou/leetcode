package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class NumberOfProvincesSpec extends Specification {

    @Unroll
    def "should return number of provinces #number for adjacency matrix #matrix"() {
        expect:
        NumberOfProvinces.findCircleNum(matrix as int[][]) == number
        where:
        matrix                                                                                | number
        [[1]]                                                                                 | 1
        [[1, 1, 0], [1, 1, 0], [0, 0, 1]]                                                     | 2
        [[1, 0, 0], [0, 1, 0], [0, 0, 1]]                                                     | 3
        [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 1, 1, 1], [0, 0, 1, 1, 1], [0, 0, 1, 1, 1]] | 2
        [[1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 1], [1, 0, 1, 1]]                              | 1
    }
}
