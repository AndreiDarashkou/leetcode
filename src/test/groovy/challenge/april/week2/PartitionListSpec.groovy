package challenge.april.week2

import challenge.april.common.ListNode
import spock.lang.Specification

class PartitionListSpec extends Specification {

    def "should move all elements from #values to left from pivot #pivot"() {
        given:
        def headNode = createNestedList(values)
        when:
        ListNode result2 = new PartitionList().partition(headNode, pivot)
        then:
        toList(result2) == result
        where:
        values                         | pivot | result
        [1, 4, 3, 2, 5, 2]             | 3     | [1, 2, 2, 4, 3, 5]
        [7, 9, 5, 4, 5, 2, 2, 6, 8, 1] | 2     | [1, 7, 9, 5, 4, 5, 2, 2, 6, 8]
        [2, 1]                         | 2     | [1, 2]
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
