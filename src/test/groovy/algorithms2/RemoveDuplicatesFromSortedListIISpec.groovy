package algorithms2

import static common.ListUtils.*
import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatesFromSortedListIISpec extends Specification {

    @Unroll
    def "should remove duplicated elements from list #list"() {
        expect:
        RemoveDuplicatesFromSortedListII.deleteDuplicates(toLinkedList(list)) == toLinkedList(result)
        where:
        list          | result
        [1, 2, 3, 9]  | [1, 2, 3, 9]
        [1, 2, 2, 9]  | [1, 9]
        [2, 2, 3, 9]  | [3, 9]
        [1, 3, 3, 3]  | [1]
        [1]           | [1]
        []            | []
        [-1, 0, 1, 1] | [-1, 0]
    }
}
