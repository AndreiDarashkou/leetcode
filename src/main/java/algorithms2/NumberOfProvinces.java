package algorithms2;

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int number = 0;
        for (int city = 0; city < isConnected.length; city++) {
            if (isConnected[city][city] == 1) {
                number++;
                removeAllConnections(isConnected, city);
            }
        }
        return number;
    }

    private static void removeAllConnections(int[][] isConnected, int city) {
        for (int another = 0; another < isConnected.length; another++) {
            if (isConnected[city][another] == 1 && isConnected[another][another] == 1) {
                isConnected[another][another] = 0;
                removeAllConnections(isConnected, another);
            }
        }
    }
}
