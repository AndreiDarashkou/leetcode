package common;

import java.util.*;

public final class ListUtils {

    private ListUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> list(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);

        return list;
    }

    public static ListNode toLinkedList(List<Integer> values) {
        ListNode headNode = null;
        Iterator<Integer> it = new ArrayDeque<>(values).descendingIterator();
        while(it.hasNext()) {
            headNode = new ListNode(it.next(), headNode);
        }
        return headNode;
    }
}
