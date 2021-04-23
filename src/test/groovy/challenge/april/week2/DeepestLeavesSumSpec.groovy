package challenge.april.week2

import static challenge.april.week2.DeepestLeavesSum.TreeNode;

import spock.lang.Specification
import spock.lang.Unroll

/**
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3704/
 *
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
class DeepestLeavesSumSpec extends Specification {

    @Unroll
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
