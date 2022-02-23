package algorithms2


import spock.lang.Specification
import spock.lang.Unroll

class NumberOfIslandsSpec extends Specification {

    @Unroll
    def "should return number of islands #number for grid #grid"() {
        expect:
        NumberOfIslands.numIslands(grid as char[][]) == number
        where:
        grid                                                | number
        [['1']]                                             | 1
        [['1', '0', '0'], ['0', '1', '0'], ['0', '0', '1']] | 3
        [['1', '0', '0'], ['0', '1', '0'], ['0', '1', '1']] | 2
        [['1', '1', '0'], ['0', '1', '0'], ['0', '1', '1']] | 1
    }
}
