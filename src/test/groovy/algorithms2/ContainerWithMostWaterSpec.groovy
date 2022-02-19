package algorithms2

import spock.lang.Specification
import spock.lang.Unroll

class ContainerWithMostWaterSpec extends Specification {

    @Unroll
    def "should return max area #maxArea for container #height"() {
        expect:
        ContainerWithMostWater.maxArea(height as int[]) == maxArea
        where:
        height                      | maxArea
        [1, 1]                      | 1
        [1, 8, 6, 2, 5, 4, 8, 3, 7] | 49
        [2, 3, 4, 4, 3, 2]          | 10
        [1, 8, 1, 8, 1, 8, 1, 10]   | 48
    }
}
