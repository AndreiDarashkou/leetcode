package test;

import challenge.april.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        System.out.println(middleNode(n1).val);

    }

    public static ListNode middleNode(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() / 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headCopy = head;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (n == list.size() && headCopy != null) { //start
            headCopy = headCopy.next;
        } else if (n == 1) { //end
            ListNode removed = list.get(list.size() - 2);
            removed.next = null;
        } else { //middle
            ListNode beforeRemoved = list.get(list.size() - 1 - n);
            beforeRemoved.next = beforeRemoved.next.next;
        }

        return headCopy;
    }

}
