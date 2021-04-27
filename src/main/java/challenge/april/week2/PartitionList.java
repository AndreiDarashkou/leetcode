package challenge.april.week2;

import challenge.april.common.ListNode;

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3707/
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater
 * than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int pivot) {
        ListNode smaller = new ListNode();
        ListNode bigger = new ListNode();

        ListNode smallerCursor = smaller;
        ListNode biggerCursor = bigger;

        ListNode cursor = head;
        while (cursor != null) {
            if (cursor.val < pivot) {
                smallerCursor.next = cursor;
                smallerCursor = cursor;
            } else {
                biggerCursor.next = cursor;
                biggerCursor = cursor;
            }
            cursor = cursor.next;
        }

        biggerCursor.next = null;
        smallerCursor.next = bigger.next;

        return smaller.next;
    }

}
