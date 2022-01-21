package algorithms2;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (row[0] <= target && row[row.length - 1] >= target) {
                return binarySearch(row, target, 0, row.length - 1);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] arr, int target, int min, int max) {
        if (min > max) {
            return false;
        }
        if (min == max) {
            return arr[min] == target;
        }
        int middle = (min + max) / 2;
        if (arr[middle] == target) {
            return true;
        }
        if (arr[middle] > target) {
            return binarySearch(arr, target, min, middle - 1);
        }
        return binarySearch(arr, target, middle + 1, max);
    }
}
