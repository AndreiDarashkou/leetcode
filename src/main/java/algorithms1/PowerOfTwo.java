package algorithms1;

/**
 * https://leetcode.com/problems/power-of-two/
 * <p>
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) {
            return false;
        }
        return (num & (num - 1)) == 0;
    }

    public static boolean isPowerOfTwo2(int num) {
        if (num <= 0) {
            return false;
        }
        boolean oneExists = false;
        while (num != 0) {
            if ((num & 1) == 1) {
                if (oneExists) {
                    return false;
                }
                oneExists = true;
            }
            num = num >> 1;
        }
        return oneExists;
    }

    public static boolean isPowerOfTwo3(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        if (num % 2 == 1) {
            return false;
        }
        return isPowerOfTwo3(num / 2);
    }
}
