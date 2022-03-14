package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class ShortestPathInBinaryMatrixSpec extends Specification {

    @Unroll
    def "should find closes path length #length for grid #grid"() {
        expect:
        ShortestPathInBinaryMatrix.shortestPathBinaryMatrix(grid as int[][]) == length
        where:
        grid                              | length
        []                                | -1
        [[0]]                             | 1
        [[0, 1], [1, 0]]                  | 2
        [[0, 0, 0], [0, 0, 0], [0, 0, 0]] | 3
        [[0, 1, 1, 1, 1, 0, 0],
         [1, 0, 0, 0, 0, 1, 0],
         [0, 1, 1, 1, 1, 1, 0],
         [0, 1, 1, 1, 1, 0, 1],
         [0, 1, 1, 1, 1, 0, 1],
         [0, 1, 1, 1, 1, 0, 1],
         [0, 1, 1, 1, 1, 0, 0]]           | 12
    }
}
