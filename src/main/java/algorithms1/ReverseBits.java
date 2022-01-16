package algorithms1;

/**
 * https://leetcode.com/problems/reverse-bits/
 * <p>
 * Reverse bits of a given 32 bits unsigned integer.
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        int shift = 31;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = result | (1 << shift);
            }
            n = n >>> 1;
            shift--;
        }
        return result;
    }
}
