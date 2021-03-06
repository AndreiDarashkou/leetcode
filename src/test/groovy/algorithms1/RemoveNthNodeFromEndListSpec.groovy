package algorithms1

import common.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class RemoveNthNodeFromEndListSpec extends Specification {

    @Unroll
    def "should remove #removedIndexFromEnd element from the end of list #values (1)"() {
        given:
        def headNode = createNestedList(values)
        when:
        ListNode result2 = RemoveNthNodeFromEndOfList.removeNthFromEnd1(headNode, removedIndexFromEnd)
        then:
        toList(result2) == result
        where:
        values                         | removedIndexFromEnd | result
        [1, 4, 3, 2, 5, 2]             | 3                   | [1, 4, 3, 5, 2]
        [7, 9, 5, 4, 5, 2, 2, 6, 8, 1] | 2                   | [7, 9, 5, 4, 5, 2, 2, 6, 1]
        [2, 1]                         | 2                   | [1]
        [1, 2, 3]                      | 1                   | [1, 2]
        [1]                            | 1                   | []
    }

    @Unroll
    def "should remove #removedIndexFromEnd element from the end of list #values (2)"() {
        given:
        def headNode = createNestedList(values)
        when:
        ListNode result2 = RemoveNthNodeFromEndOfList.removeNthFromEnd2(headNode, removedIndexFromEnd)
        then:
        toList(result2) == result
        where:
        values                         | removedIndexFromEnd | result
        [1, 4, 3, 2, 5, 2]             | 3                   | [1, 4, 3, 5, 2]
        [7, 9, 5, 4, 5, 2, 2, 6, 8, 1] | 2                   | [7, 9, 5, 4, 5, 2, 2, 6, 1]
        [2, 1]                         | 2                   | [1]
        [1, 2, 3]                      | 1                   | [1, 2]
        [1]                            | 1                   | []
    }

    static def createNestedList(List<Integer> values) {
        ListNode nestedList
        values.reverse().each {
            nestedList = new ListNode(it, nestedList)
        }
        return nestedList
    }

    static def toList(ListNode node) {
        def result = []
        while (node != null) {
            result.add(node.val)
            node = node.next
        }
        result
    }
}
