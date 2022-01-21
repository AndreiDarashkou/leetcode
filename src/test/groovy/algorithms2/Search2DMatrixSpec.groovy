package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class Search2DMatrixSpec extends Specification {

    @Unroll
    def "should find element #target in matrix #matrix"() {
        expect:
        Search2DMatrix.searchMatrix(matrix as int[][], target) == result
        where:
        target | result | matrix
        5      | true   | [[1, 2, 3], [4, 5, 6]]
        5      | false  | [[1, 2, 3], [4, 6, 7]]
        8      | true   | [[-1, 0, 8], [9, 11, 17]]
        19     | false  | [[-1, 0, 8], [9, 11, 17], [17, 17, 18]]
        -4     | false  | [[-1, 0, 8], [9, 11, 17]]
    }
}
