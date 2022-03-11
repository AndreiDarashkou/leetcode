package algorithms2

import common.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

class SubtreeOfAnotherTreeSpec extends Specification {

    @Unroll
    def "should return #isFound subtree #subtree in tree #tree"() {
        expect:
        SubtreeOfAnotherTree.isSubtree(TreeNode.of(tree), TreeNode.of(subtree)) == isFound
        where:
        tree                                       | subtree   | isFound
        [1]                                        | [1]       | true
        [2, 1, 3]                                  | [2, 1, 3] | true
        [2, 1, 3]                                  | [3]       | true
        [3, 4, 5, 1, 2]                            | [4, 1, 2] | true
        [3, 4, 5, 1, 2, null, null, null, null, 0] | [4, 1, 2] | false
        [1, 1]                                     | [1]       | true
    }
}
