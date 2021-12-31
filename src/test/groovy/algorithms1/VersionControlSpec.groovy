package algorithms1

import spock.lang.Specification
import spock.lang.Unroll

class VersionControlSpec extends Specification {

    @Unroll
    def "should return first invalid version #firstInvalid if current #current"() {
        given:
        VersionControl versionControl = new VersionControl(firstInvalid)
        expect:
        versionControl.findBadVersion(current) == firstInvalid
        where:
        firstInvalid | current
        5            | 10
        80           | 432
        10           | 19
        1            | 11
    }
}
