package challenge.april.week3;

public class NumberSubmatricesThatSumTarget {

    private int[][][][] cache;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        cache = new int[matrix.length][matrix[0].length][matrix.length + 1][matrix[0].length + 1];

        int count = 0;
        for (int height = 1; height <= matrix.length; height++) {
            for (int width = 1; width <= matrix[0].length; width++) {

                for (int row = 0; row <= matrix.length - height; row++) {
                    for (int col = 0; col <= matrix[0].length - width; col++) {
                        int sum = sum(matrix, row, col, width, height);
                        if (sum == target) {
                            count++;
                        }
                    }
                }

            }
        }
        return count;
    }

    private int sum(int[][] matrix, int row, int col, int width, int height) {
        if (width == 1 && height == 1) {
            cache[row][col][width][height] = matrix[row][col];
            return matrix[row][col];
        }

        if (cache[row][col][width][height] != 0) {
            return cache[row][col][width][height];
        }

        int sum = 0;

        if (height > width) {
            for (int h = 0; h < height; h++) {
                sum += sum(matrix, row + h, col, width, 1);
            }
        } else {
            for (int w = 0; w < width; w++) {
                sum += sum(matrix, row, col + w, 1, height);
            }
        }

        cache[row][col][width][height] = sum;

        return sum;
    }

}
