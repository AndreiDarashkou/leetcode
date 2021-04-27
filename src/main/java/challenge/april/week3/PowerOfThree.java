package challenge.april.week3;

public class PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(729));
    }

    public static boolean isPowerOfThree(int n) {
        while ((n = n / 3) > 1) {
            if (n % 3 != 0) {
                return false;
            }
        }
        return n == 1;
    }

}
