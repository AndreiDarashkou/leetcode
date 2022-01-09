package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class CombinationsSpec extends Specification {

    @Unroll
    def "should combine all possible combinations for n #n and k #k"() {
        expect:
        Combinations.combine(n, k) == combinations
        where:
        n | k | combinations
        3 | 3 | [[1, 2, 3]]
        3 | 1 | [[1], [2], [3]]
        3 | 2 | [[1, 2], [1, 3], [2, 3]]
        4 | 3 | [[1, 2, 3], [1, 2, 4], [1, 3, 4], [2, 3, 4]]
        4 | 2 | [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
        6 | 4 | [[1, 2, 3, 4], [1, 2, 3, 5], [1, 2, 3, 6], [1, 2, 4, 5], [1, 2, 4, 6], [1, 2, 5, 6], [1, 3, 4, 5], [1, 3, 4, 6], [1, 3, 5, 6], [1, 4, 5, 6], [2, 3, 4, 5], [2, 3, 4, 6], [2, 3, 5, 6], [2, 4, 5, 6], [3, 4, 5, 6]]
    }
}
