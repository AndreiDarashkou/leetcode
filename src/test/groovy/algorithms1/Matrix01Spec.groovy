package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class Matrix01Spec extends Specification {

    @Unroll
    def "should update #matrix to #result"() {
        expect:
        Matrix01.updateMatrix(matrix as int[][]) == result as int[][]
        where:
        matrix                                                   | result
        [[0, 0, 0], [0, 1, 0], [1, 1, 1]]                        | [[0, 0, 0], [0, 1, 0], [1, 2, 1]]
        [[0, 1, 1], [0, 1, 1], [1, 1, 1]]                        | [[0, 1, 2], [0, 1, 2], [1, 2, 3]]
        [[0, 1, 0, 1], [0, 1, 0, 1], [1, 1, 1, 1], [1, 1, 1, 1]] | [[0, 1, 0, 1], [0, 1, 0, 1], [1, 2, 1, 2], [2, 3, 2, 3]]
    }
}
