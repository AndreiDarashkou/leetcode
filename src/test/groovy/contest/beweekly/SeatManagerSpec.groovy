package contest.beweekly

import contest.beweekly51.SeatManager
import spock.lang.Specification
import spock.lang.Unroll

class SeatManagerSpec extends Specification {

    @Unroll
    def "should return next available seat: #result where available seats: #unreserve"() {
        given:
        def seatManager = new SeatManager(size)
        when:
        reserveTimes.times {
            seatManager.reserve()
        }
        unreserve.each {
            seatManager.unreserve(it)
        }
        then:
        seatManager.reserve() == result
        where:
        size | reserveTimes | unreserve       | result
        5    | 3            | [2]             | 2
        10   | 5            | [5, 3]          | 3
        10   | 10           | [5, 3, 7, 2, 8] | 2
        10   | 10           | []              | -1
    }
}
