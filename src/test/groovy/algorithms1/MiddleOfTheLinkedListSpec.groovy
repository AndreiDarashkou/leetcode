package algorithms1

import common.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class MiddleOfTheLinkedListSpec extends Specification {

    @Unroll
    def "should return middle element from linked list #values"() {
        given:
        def headNode = createLinkedList(values)
        when:
        ListNode middleNode = MiddleOfTheLinkedList.middleNode(headNode)
        then:
        middleNode.val == middleVal
        where:
        values             | middleVal
        [1, 4, 3, 2, 5, 0] | 2
        [1, 4, 3, 2, 5]    | 3
        [1]                | 1
        [1, 2]             | 2
        [1, 3, 2]          | 3
    }

    static def createLinkedList(List<Integer> values) {
        ListNode headNode
        values.reverse().each {
            headNode = new ListNode(it, headNode)
        }
        return headNode
    }
}
