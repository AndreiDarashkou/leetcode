package algorithms1

import common.ListNode
import spock.lang.Specification
import spock.lang.Unroll

class MergeTwoSortedListsSpec extends Specification {

    @Unroll
    def "should merge two lists to #mergedList"() {
        given:
        ListNode root1 = toLinkedList(list1)
        ListNode root2 = toLinkedList(list2)

        expect:
        MergeTwoSortedLists.mergeTwoLists(root1, root2) == toLinkedList(mergedList)
        where:
        list1        | list2           | mergedList
        [1, 2, 3, 9] | [2, 5, 7]       | [1, 2, 2, 3, 5, 7, 9]
        [1, 1, 1, 2] | [0, 1, 3, 4, 9] | [0, 1, 1, 1, 1, 2, 3, 4, 9]
        [1, 2, 3]    | [1, 2, 3]       | [1, 1, 2, 2, 3, 3]
    }

    static def toLinkedList(List<Integer> values) {
        ListNode headNode
        values.reverse().each {
            headNode = new ListNode(it, headNode)
        }
        return headNode
    }
}
