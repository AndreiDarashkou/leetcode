package algorithms1

import common.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class MergeTwoBinaryTreesSpec extends Specification {

    @Unroll
    def "should merge tree #tree1 with #tree2 into #mergedTree"() {
        given:
        TreeNode root1 = toTree(tree1)
        TreeNode root2 = toTree(tree2)

        expect:
        MergeTwoBinaryTrees.mergeTrees(root1, root2) == toTree(mergedTree)
        where:
        tree1              | tree2                       | mergedTree
        [1, 2, 3, 4]       | [1, 2, 3, 4]                | [2, 4, 6, 8]
        [1, 2, null, 4, 5] | [1, 2, 3, 4, 5, 6, 7]       | [2, 4, 3, 8, 10, 6, 7]
        [1, 3, 2, 5]       | [2, 1, 3, null, 4, null, 7] | [3, 4, 5, 5, 4, null, 7]
    }

    static def toTree(List<Integer> list) {
        def nodes = list.collect { it == null ? null : new TreeNode(it) }
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode current = nodes.get(i)
            if (current == null) {
                continue
            }
            if (i * 2 + 1 < nodes.size()) {
                current.left = nodes.get(1 + i * 2)
            }
            if (i * 2 + 2 < nodes.size()) {
                current.right = nodes.get(2 + i * 2)
            }
        }
        return nodes.get(0)
    }
}
