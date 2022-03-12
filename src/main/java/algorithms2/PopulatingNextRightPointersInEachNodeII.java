package algorithms2;

import common.Node;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            while (size-- > 0) {
                Node next = queue.remove();
                if (prev != null) {
                    prev.next = next;
                }
                prev = next;
                if (next.left != null) {
                    queue.add(next.left);
                }
                if (next.right != null) {
                    queue.add(next.right);
                }
            }
        }
        return root;
    }

}
