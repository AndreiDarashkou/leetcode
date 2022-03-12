package algorithms1

import common.Node
import spock.lang.Specification

class PopulatingNextRightPointersInEachNodeSpec extends Specification {

    def "should connect nodes (1)"() {
        given:
        Node root = root()
        when:
        Node result = PopulatingNextRightPointersInEachNode.connect(root)
        then:
        result.left.next == result.right
        result.left.left.next == result.left.right
    }

    def "should connect nodes (2)"() {
        given:
        Node root = root()
        when:
        Node result = PopulatingNextRightPointersInEachNode.connect2(root)
        then:
        result.left.next == result.right
        result.left.left.next == result.left.right
    }

    def "should connect nodes (3)"() {
        given:
        Node root = root()
        when:
        Node result = PopulatingNextRightPointersInEachNode.connect3(root)
        then:
        result.left.next == result.right
        result.left.left.next == result.left.right
    }

    static def root() {
        Node node4 = node(4, node(8), node(9))
        Node node5 = node(5, node(10), node(11))
        Node node6 = node(6, node(12), node(13))
        Node node7 = node(7, node(14), node(15))

        Node node2 = node(2, node4, node5)
        Node node3 = node(3, node6, node7)

        return node(1, node2, node3)
    }

    static def node(int val, Node left, Node right) {
        return new Node(val, left, right, null)
    }

    static def node(int val) {
        return new Node(val)
    }
}
