package algorithms2

import spock.lang.Specification

class IntervalListIntersectionsSpec extends Specification {

    def "test intervalIntersection"() {
        expect:
        IntervalListIntersections.intervalIntersection(firstList as int[][], secondList as int[][]) == resultList as int[][]
        where:
        firstList                             | secondList                            | resultList
        [[1, 3], [5, 9]]                      | []                                    | []
        [[1, 3]]                              | [[2, 5]]                              | [[2, 3]]
        [[2, 3]]                              | [[1, 5]]                              | [[2, 3]]
        [[1, 3], [5, 9]]                      | [[2, 5], [7, 8]]                      | [[2, 3], [5, 5], [7, 8]]
        [[0, 2], [5, 10], [13, 23], [24, 25]] | [[1, 5], [8, 12], [15, 24], [25, 26]] | [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]
        [[1, 5], [8, 12], [15, 24], [25, 26]] | [[0, 2], [5, 10], [13, 23], [24, 25]] | [[1, 2], [5, 5], [8, 10], [15, 23], [24, 24], [25, 25]]
    }
}
