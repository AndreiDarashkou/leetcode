package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class RottingOrangesSpec extends Specification {

    @Unroll
    def "should rott all oranges #matrix for #days days (1)"() {
        expect:
        RottingOranges.orangesRotting(matrix as int[][]) == days
        where:
        matrix                            | days
        [[0, 0, 0], [0, 1, 0], [1, 2, 1]] | 1
        [[2, 1, 0], [0, 1, 0], [1, 1, 1]] | 4
        [[2, 1, 0], [0, 1, 0], [1, 0, 1]] | -1
    }

    @Unroll
    def "should rott all oranges #matrix for #days days (2)"() {
        expect:
        RottingOranges.orangesRotting2(matrix as int[][]) == days
        where:
        matrix                            | days
        [[0, 0, 0], [0, 1, 0], [1, 2, 1]] | 1
        [[2, 1, 0], [0, 1, 0], [1, 1, 1]] | 4
        [[2, 1, 0], [0, 1, 0], [1, 0, 1]] | -1
    }

}
