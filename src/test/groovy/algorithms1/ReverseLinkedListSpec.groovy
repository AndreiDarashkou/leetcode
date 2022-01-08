package algorithms1

import common.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class ReverseLinkedListSpec extends Specification {

    @Unroll
    def "should reverse list #list to #reversedList"() {
        expect:
        ReverseLinkedList.reverseList(toLinkedList(list)) == toLinkedList(reversedList)
        where:
        list             | reversedList
        [1, 2, 3, 9]     | [9, 3, 2, 1]
        [6, 1, 7, 2, -9] | [-9, 2, 7, 1, 6]
        []               | []
    }

    static def toLinkedList(List<Integer> values) {
        ListNode headNode
        values.reverse().each {
            headNode = new ListNode(it, headNode)
        }
        return headNode
    }
}
