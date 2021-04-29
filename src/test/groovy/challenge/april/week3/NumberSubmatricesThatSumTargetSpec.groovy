package challenge.april.week3

import spock.lang.Specification
import spock.lang.Unroll

class NumberSubmatricesThatSumTargetSpec extends Specification {

    @Unroll
    def "should return #count submatrices from matrix #matrix where sum: #sum"() {
        given:
        def algorithm = new NumberSubmatricesThatSumTarget()
        expect:
        algorithm.numSubmatrixSumTarget(matrix as int[][], sum) == count
        where:
        matrix                                                    | sum | count
        [[0, 1, 0], [1, 1, 1], [0, 1, 0]]                         | 3   | 6
        [[1, 2, 3, 4], [4, 3, 2, 1], [0, 1, 0, 2], [5, -1, 6, 0]] | 5   | 15
    }
}
