package algorithms2;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<TreeNode> roots = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == subRoot.val) {
                if (compare(node, subRoot)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return false;
    }

    private static boolean compare(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
    }
}
