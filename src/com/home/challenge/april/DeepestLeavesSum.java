package com.home.challenge.april;

public class DeepestLeavesSum {

    private static int deepestLeaf;
    private static final int[] leaf = new int[100];

    public static int deepestLeavesSum(TreeNode root) {
        inorderTraverse(root, 0);

        return leaf[deepestLeaf];
    }

    private static void inorderTraverse(TreeNode node, int deep) {
        deep++;
        if (node.left != null) {
            inorderTraverse(node.left, deep);
        }
        if (node.right != null) {
            inorderTraverse(node.right, deep);
        }
        if (node.right == null && node.left == null) {
            if (leaf[deep] != 0) {
                leaf[deep] = leaf[deep] + node.val;
            } else {
                leaf[deep] = node.val;
                if (deep > deepestLeaf) {
                    deepestLeaf = deep;
                }
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
