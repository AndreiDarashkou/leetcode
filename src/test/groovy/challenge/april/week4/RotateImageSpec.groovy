package challenge.april.week4

import spock.lang.Specification
import spock.lang.Unroll

class RotateImageSpec extends Specification {

    @Unroll
    def "should return rotated matrix by 90 degree #rotated"() {
        given:
        def image = matrix as int[][]
        when:
        RotateImage.rotate(image)
        then:
        image == rotated as int[][]
        where:
        matrix                                                          | rotated
        [[1, 2], [3, 4]]                                                | [[3, 1], [4, 2]]
        [[1, 2, 3], [4, 5, 6], [7, 8, 9]]                               | [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
        [[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]] | [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
    }

}
