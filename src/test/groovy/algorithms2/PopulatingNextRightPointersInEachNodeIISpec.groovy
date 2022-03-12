package algorithms2

import common.Node
import spock.lang.Specification
import spock.lang.Unroll

class PopulatingNextRightPointersInEachNodeIISpec extends Specification {

    @Unroll
    def "should connect nodes for tree #tree"() {
        given:
        Node root = Node.of(tree)
        expect:
        Node.of(tree) == PopulatingNextRightPointersInEachNodeII.connect(root)
        where:
        tree                              | result
        []                                | []
        [1, 2, 3, 4, 5, null, 7]          | [1, null, 2, 3, null, 4, 5, 7, null]
        [1, 2, null, 3, null, 4, null, 5] | [1, null, 2, null, 3, null, 4, null, 5, null]
    }
}
