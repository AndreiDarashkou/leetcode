package challenge.april.week3;

import challenge.april.common.ListNode;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3712/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] nodes = new ListNode[30];
        int size = 0;
        while (head != null) {
            nodes[size++] = head;
            head = head.next;
        }

        int remove = size - n;
        if (remove == 0) {
            return nodes[1];
        }
        nodes[remove - 1].next = nodes[remove + 1];

        return nodes[0];
    }

}
