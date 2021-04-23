package challenge.april.week2;

import challenge.april.common.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int pivot) {
        ListNode smaller = new ListNode();

        ListNode smallerCursor = smaller, cursor = head;
        while (cursor.next != null) {
            if (cursor.val < pivot) {
                smallerCursor.next = cursor;
                smallerCursor = cursor;

                cursor = cursor.next.next;
            }
            cursor = cursor.next;
        }

        System.out.println(smallerCursor);

        return smaller.next;
    }

}
