package algorithms2;

import common.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesFromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode();
        ListNode tail = root;
        int prev = -101;

        while (head != null) {
            //if current not equal prev and next
            if (head.val != prev && (head.next == null || head.val != head.next.val)) {
                tail.next = new ListNode(head.val);
                tail = tail.next;
            }
            prev = head.val;
            head = head.next;
        }
        return root.next;
    }
}
