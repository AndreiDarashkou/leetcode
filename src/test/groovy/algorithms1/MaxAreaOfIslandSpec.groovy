package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class MaxAreaOfIslandSpec extends Specification {

    @Unroll
    def "should find and island with max area #maxArea"() {
        expect:
        MaxAreaOfIsland.maxAreaOfIsland(grid as int[][]) == maxArea
        where:
        maxArea | grid
        7       | [[1, 1, 0, 1],
                   [1, 1, 0, 1],
                   [0, 0, 1, 1],
                   [1, 1, 1, 0]]
        6       | [[1, 0, 1, 1, 1, 1],
                   [1, 1, 0, 1, 0, 1],
                   [0, 0, 1, 0, 0, 0],
                   [1, 1, 1, 0, 1, 1]]
    }
}
