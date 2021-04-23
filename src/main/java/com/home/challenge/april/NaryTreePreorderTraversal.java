package com.home.challenge.april;

import java.util.*;

public class NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.children == null) {
            return List.of(root.val);
        }
        List<Integer> result = new ArrayList<>();
        preorderTraverse(root, result);

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node child3 = new Node(3);
        child3.children = List.of(new Node(5), new Node(6));

        Node child4 = new Node(4);
        child4.children = List.of(new Node(7), new Node(8));

        root.children = List.of(new Node(2), child3, child4);

        List<Integer> result = new ArrayList<>();
        preorderTraverse(root, result);

        System.out.println(result);
        System.out.println(preorder2(root));
    }

    private static void preorderTraverse(Node node, List<Integer> inorderList) {
        inorderList.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                preorderTraverse(child, inorderList);
            }
        }
    }

    public static List<Integer> preorder2(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.children == null) {
            return List.of(root.val);
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.add(root);
        List<Integer> values = new ArrayList<>();

        while (!stack.isEmpty()) {
            Node next = stack.removeLast();
            values.add(next.val);
            if (next.children != null) {
                for (int i = next.children.size() - 1; i >= 0; i--) {
                    stack.add(next.children.get(i));
                }
            }
        }
        return values;
    }

}