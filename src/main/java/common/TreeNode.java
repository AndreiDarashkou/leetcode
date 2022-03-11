package common;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(List<Integer> values) {
        List<TreeNode> nodes = values.stream().map(val -> val == null ? null : new TreeNode(val))
                .collect(Collectors.toList());
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode current = nodes.get(i);
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
        return nodes.get(0);
    }

    @Override
    public String toString() {
        return val + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}
