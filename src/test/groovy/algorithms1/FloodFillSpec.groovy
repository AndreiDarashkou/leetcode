package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class FloodFillSpec extends Specification {

    @Unroll
    def "should color #image to #result when row #row col #col (1)"() {
        expect:
        FloodFill.floodFill(image as int[][], row, col, color) == result as int[][]
        where:
        image                                                    | row | col | color | result
        [[1, 1, 1], [1, 1, 0], [1, 0, 1]]                        | 0   | 0   | 2     | [[2, 2, 2],
                                                                                        [2, 2, 0],
                                                                                        [2, 0, 1]]
        [[1, 0, 0], [1, 1, 1], [1, 0, 0]]                        | 1   | 2   | 3     | [[3, 0, 0],
                                                                                        [3, 3, 3],
                                                                                        [3, 0, 0]]
        [[0, 1, 0, 1], [0, 1, 0, 1], [1, 1, 1, 1], [1, 1, 1, 1]] | 1   | 1   | 2     | [[0, 2, 0, 2],
                                                                                        [0, 2, 0, 2],
                                                                                        [2, 2, 2, 2],
                                                                                        [2, 2, 2, 2]]
    }

    @Unroll
    def "should color #image to #result when row #row col #col (2)"() {
        expect:
        FloodFill.floodFill2(image as int[][], row, col, color) == result as int[][]
        where:
        image                                                    | row | col | color | result
        [[1, 1, 1], [1, 1, 0], [1, 0, 1]]                        | 0   | 0   | 2     | [[2, 2, 2],
                                                                                        [2, 2, 0],
                                                                                        [2, 0, 1]]
        [[1, 0, 0], [1, 1, 1], [1, 0, 0]]                        | 1   | 2   | 3     | [[3, 0, 0],
                                                                                        [3, 3, 3],
                                                                                        [3, 0, 0]]
        [[0, 1, 0, 1], [0, 1, 0, 1], [1, 1, 1, 1], [1, 1, 1, 1]] | 1   | 1   | 2     | [[0, 2, 0, 2],
                                                                                        [0, 2, 0, 2],
                                                                                        [2, 2, 2, 2],
                                                                                        [2, 2, 2, 2]]
    }

    @Unroll
    def "should color #image to #result when row #row col #col (3)"() {
        expect:
        FloodFill.floodFill3(image as int[][], row, col, color) == result as int[][]
        where:
        image                                                    | row | col | color | result
        [[1, 1, 1], [1, 1, 0], [1, 0, 1]]                        | 0   | 0   | 2     | [[2, 2, 2],
                                                                                        [2, 2, 0],
                                                                                        [2, 0, 1]]
        [[1, 0, 0], [1, 1, 1], [1, 0, 0]]                        | 1   | 2   | 3     | [[3, 0, 0],
                                                                                        [3, 3, 3],
                                                                                        [3, 0, 0]]
        [[0, 1, 0, 1], [0, 1, 0, 1], [1, 1, 1, 1], [1, 1, 1, 1]] | 1   | 1   | 2     | [[0, 2, 0, 2],
                                                                                        [0, 2, 0, 2],
                                                                                        [2, 2, 2, 2],
                                                                                        [2, 2, 2, 2]]
    }
}
