package medium


import common.NestedIntegerImpl
import spock.lang.Specification
import spock.lang.Unroll

class NestedIteratorSpec extends Specification {

    @Unroll
    def "should unfold all elements from #nested"() {
        given:
        def nestedList = createNestedList(nested)
        def iterator = new NestedIterator(nestedList)
        expect:
        iterator.toList() == result
        where:
        nested                              | result
        [[1, 1], 2, [1, 1]]                 | [1, 1, 2, 1, 1]
        [1, [2, [3, 4, [5]]], 6, 7, [8, 9]] | [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    def createNestedList(Object nested) {
        def nestedList = []
        nested.each {
            if (it instanceof List) {
                nestedList.add(new NestedIntegerImpl(createNestedList(it) as List))
            } else {
                nestedList.add(new NestedIntegerImpl(it as Integer))
            }
        }
        return nestedList
    }
}
