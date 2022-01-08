package algorithms1;

import common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <p>
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = list1;
        ListNode right = list2;
        ListNode head = new ListNode();
        ListNode res = head;

        while (true) {
            if (left == null) {
                head.next = right;
                break;
            } else if (right == null) {
                head.next = left;
                break;
            } else if (left.val <= right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        return res.next;
    }
}
