package algorithms1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);

        return root;
    }

    private static void connect(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }

    public static Node connect2(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        Node levelRoot = root;
        while (levelRoot != null) {
            if (levelRoot.left != null) {
                levelRoot.left.next = levelRoot.right;
            }

            Node left = levelRoot;
            Node sibling = levelRoot.next;
            while (sibling != null && sibling.left != null) {
                left.right.next = sibling.left;
                sibling.left.next = sibling.right;

                left = sibling;
                sibling = sibling.next;
            }
            levelRoot = levelRoot.left;
        }
        return root;
    }

    //1. breadth-first traversal
    //2. convert to list of nodes
    //3. connect all nodes
    //4. remove connection for right nodes
    public static Node connect3(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        List<Node> list = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node);
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).next = list.get(i);
        }
        Node node = root;
        while (node != null) {
            node.next = null;
            node = node.right;
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

}
