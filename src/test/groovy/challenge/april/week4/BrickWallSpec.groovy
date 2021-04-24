package challenge.april.week4

import spock.lang.Specification
import spock.lang.Unroll

class BrickWallSpec extends Specification {

    @Unroll
    def "should return the least count of crossed bricks #result if wal #wall"() {
        expect:
        BrickWall.leastBricks(wall as List<List<Integer>>) == result
        where:
        wall                                                                  | result
        [[1], [1], [1]]                                                       | 3
        [[1, 1], [2], [1, 1]]                                                 | 1
        [[1, 2, 2, 1], [3, 1, 2], [1, 3, 2], [2, 4], [3, 1, 2], [1, 3, 1, 1]] | 2
    }

    @Unroll
    def "should return the least count of crossed bricks #result if wal #wall (second approach)"() {
        expect:
        BrickWall.leastBricks2(wall as List<List<Integer>>) == result
        where:
        wall                                                                  | result
        [[1], [1], [1]]                                                       | 3
        [[1, 1], [2], [1, 1]]                                                 | 1
        [[1, 2, 2, 1], [3, 1, 2], [1, 3, 2], [2, 4], [3, 1, 2], [1, 3, 1, 1]] | 2
    }

}
