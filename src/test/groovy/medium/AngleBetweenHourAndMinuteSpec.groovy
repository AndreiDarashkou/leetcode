package medium

import medium.AngleBetweenHandsOfAClock
import spock.lang.Specification
import spock.lang.Unroll

class AngleBetweenHourAndMinuteSpec extends Specification {

    @Unroll
    def "should return angle #angle for hour #hour and minutes #minutes"() {
        expect:
        AngleBetweenHandsOfAClock.angle(hour, minutes) == angle as double
        where:
        hour | minutes | angle
        12   | 30      | 165.0
        11   | 45      | 82.5
        11   | 10      | 85.0
    }
}
