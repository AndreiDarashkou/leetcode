package common;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Node {
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

    public static Node of(List<Integer> values) {
        List<Node> nodes = values.stream().map(val -> val == null ? null : new Node(val))
                .collect(Collectors.toList());
        for (int i = 0; i < nodes.size(); i++) {
            Node current = nodes.get(i);
            if (current == null) {
                continue;
            }
            if (i * 2 + 1 < nodes.size()) {
                current.left = nodes.get(1 + i * 2);
            }
            if (i * 2 + 2 < nodes.size()) {
                current.right = nodes.get(2 + i * 2);
            }
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return val + "->" + next;
    }
}
