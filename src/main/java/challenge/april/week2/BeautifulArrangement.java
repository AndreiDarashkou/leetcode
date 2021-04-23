package challenge.april.week2;

public class BeautifulArrangement {

    public int[] constructArray(int n, int k) {
        int size = n;
        int[] result = new int[size];

        for (int index = 0, val = 1; val <= n; index++) {
            if (index == size - k) {
                result[index] = n--;
                k -= 2;
            } else {
                result[index] = val++;
            }
        }
        return result;
    }

}
