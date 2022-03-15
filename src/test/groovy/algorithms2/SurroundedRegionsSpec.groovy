package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class SurroundedRegionsSpec extends Specification {

    @Unroll
    def "should return only surrounded 'O' #surrounded"() {
        expect:
        SurroundedRegions.solve(board as char[][]) == surrounded as char[][]
        where:
        board                                                                                                                                                                                            | surrounded
        [['O', 'O'], ['O', 'O']]                                                                                                                                                                         | [['O', 'O'], ['O', 'O']]
        [['O', 'O', 'X'], ['X', 'X', 'X'], ['X', 'O', 'X']]                                                                                                                                              | [['O', 'O', 'X'], ['X', 'X', 'X'], ['X', 'O', 'X']]
        [['O', 'O', 'O'], ['O', 'O', 'O'], ['O', 'O', 'O']]                                                                                                                                              | [['O', 'O', 'O'], ['O', 'O', 'O'], ['O', 'O', 'O']]
        [['X', 'X', 'X', 'X'], ['X', 'O', 'O', 'X'], ['X', 'X', 'O', 'X'], ['X', 'O', 'X', 'X']]                                                                                                         | [['X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X'], ['X', 'O', 'X', 'X']]
        [['X', 'X', 'X', 'X', 'X'], ['X', 'O', 'O', 'O', 'X'], ['X', 'X', 'O', 'O', 'X'], ['X', 'X', 'X', 'O', 'X'], ['X', 'O', 'X', 'X', 'X']]                                                          | [['X', 'X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X', 'X'], ['X', 'X', 'X', 'X', 'X'], ['X', 'O', 'X', 'X', 'X']]
        [['O', 'O', 'O', 'O', 'X', 'X'], ['O', 'O', 'O', 'O', 'O', 'O'], ['O', 'X', 'O', 'X', 'O', 'O'], ['O', 'X', 'O', 'O', 'X', 'O'], ['O', 'X', 'O', 'X', 'O', 'O'], ['O', 'X', 'O', 'O', 'O', 'O']] | [['O', 'O', 'O', 'O', 'X', 'X'], ['O', 'O', 'O', 'O', 'O', 'O'], ['O', 'X', 'O', 'X', 'O', 'O'], ['O', 'X', 'O', 'O', 'X', 'O'], ['O', 'X', 'O', 'X', 'O', 'O'], ['O', 'X', 'O', 'O', 'O', 'O']]
    }
}
