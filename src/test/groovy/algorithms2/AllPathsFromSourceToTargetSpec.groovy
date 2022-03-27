package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class AllPathsFromSourceToTargetSpec extends Specification {

    @Unroll
    def "should find all paths"() {
        expect:
        new AllPathsFromSourceToTarget().allPathsSourceTarget(graph as int[][]) == result
        where:
        graph                                | result
        [[1, 2], [3], [3], []]               | [[0, 1, 3], [0, 2, 3]]
        [[4, 3, 1], [3, 2, 4], [3], [4], []] | [[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]
    }

}
