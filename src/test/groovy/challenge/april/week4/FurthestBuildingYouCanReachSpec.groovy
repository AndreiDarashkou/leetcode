package challenge.april.week4

import spock.lang.Specification
import spock.lang.Unroll

class FurthestBuildingYouCanReachSpec extends Specification {

    @Unroll
    def "should return the furthest building index with heights #heights"() {
        expect:
        new FurthestBuildingYouCanReach().furthestBuilding(heights as int[], bricks, ladders) == furthest
        where:
        heights                         | bricks | ladders | furthest
        [4, 2, 7, 6, 9, 14, 12]         | 5      | 1       | 4
        [4, 12, 2, 7, 3, 18, 20, 3, 19] | 10     | 2       | 7
        [1, 7, 6, 8, 2, 3, 7, 2, 9]     | 8      | 1       | 7
        [1, 8, 9, 20, 9, 10, 100, 1]    | 9      | 2       | 7
    }
}
