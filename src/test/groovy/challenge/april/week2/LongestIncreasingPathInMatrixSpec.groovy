package challenge.april.week2

import spock.lang.Specification
import spock.lang.Unroll

class LongestIncreasingPathInMatrixSpec extends Specification {

    @Unroll
    def "should return longest path length for path #matrix"() {
        given:
        def pathInMatrix = new LongestIncreasingPathInMatrix()
        expect:
        pathInMatrix.longestIncreasingPath(matrix as int[][]) == longest
        where:
        matrix                                                    | longest
        [[9, 9, 4], [6, 6, 8], [2, 1, 1]]                         | 4
        [[3, 4, 5], [3, 2, 6], [2, 2, 1]]                         | 4
        [[1, 2, 3], [6, 5, 4], [7, 8, 9]]                         | 9
        [[5, 7, 10, 9], [1, 2, 3, 7], [9, 4, 2, 7], [8, 8, 5, 3]] | 6
        [[9, 9, 4], [6, 6, 8], [2, 1, 1]]                         | 4
    }
}
