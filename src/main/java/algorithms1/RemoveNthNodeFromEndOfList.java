package algorithms1;

import common.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class RemoveNthNodeFromEndOfList {

    // memory O(n), time O(n)
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode[] list = new ListNode[30];
        int index = 0;
        while (head != null) {
            list[index++] = head;
            head = head.next;
        }
        int remove = index - n;
        if (remove == 0) {
            return list[1];
        }
        list[remove - 1].next = list[remove + 1];

        return list[0];
    }

    // memory O(1) time O(n)
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode index = head;
        while (n > 0) {
            index = index.next;
            n--;
        }
        if (index == null) {//n == size => remove first element
            return head.next;
        }
        ListNode copy = head;
        while (index.next != null) {
            index = index.next;
            copy = copy.next;
        }
        copy.next = copy.next.next;

        return head;
    }
}
