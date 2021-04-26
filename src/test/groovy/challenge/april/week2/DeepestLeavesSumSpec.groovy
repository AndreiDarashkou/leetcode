package challenge.april.week2

import spock.lang.Specification

import static challenge.april.week2.DeepestLeavesSum.TreeNode

class DeepestLeavesSumSpec extends Specification {

    def "should return the sum of values of tree deepest leaves"() {
        given:
        TreeNode node4 = new TreeNode(4, new TreeNode(7), null)
        TreeNode node2 = new TreeNode(2, node4, new TreeNode(5))

        TreeNode node6 = new TreeNode(6, null, new TreeNode(8))
        TreeNode node3 = new TreeNode(3, null, node6)

        TreeNode root = new TreeNode(1, node2, node3)

        expect:
        DeepestLeavesSum.deepestLeavesSum(root) == 15
    }
}
