package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class PermutationsSpec extends Specification {

    @Unroll
    def "should return all possible permutations for #nums"() {
        expect:
        Permutations.permute(nums as int[]) == permutations
        where:
        nums      | permutations
        []        | []
        [1]       | [[1]]
        [1, 2]    | [[2, 1], [1, 2]]
        [1, 2, 3] | [[3, 2, 1], [2, 3, 1], [1, 3, 2], [3, 1, 2], [2, 1, 3], [1, 2, 3]]
    }
}
