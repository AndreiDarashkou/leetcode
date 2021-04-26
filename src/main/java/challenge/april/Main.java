package challenge.april;

import challenge.april.common.ListNode;
import challenge.april.week2.PartitionList;
import challenge.april.week2.VerifyingAlienDictionary;
import challenge.april.week3.CombinationSum;
import challenge.april.week3.NumberSubmatricesThatSumTarget;
import challenge.april.week3.RemoveAllAdjacentDuplicatesInString2;
import challenge.april.week3.RemoveNthNodeFromEndList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        //testVerifyingAlienDictionary();
        //testPartitionList();
        //testRemoveAllAdjacentDuplicatesInString();
        //testNumberSubmatricesThatSumTarget();
        //testRemoveNthNodeFromEndList();
        testCombinationSum();
    }

    private static void testCombinationSum() {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum4(new int[]{1, 2, 3}, 5));
    }

    private static void testRemoveNthNodeFromEndList() {
        RemoveNthNodeFromEndList list = new RemoveNthNodeFromEndList();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6,
                new ListNode(7)))))));
        System.out.println(list.removeNthFromEnd(node, 7));
    }

    private static void testNumberSubmatricesThatSumTarget() {
        NumberSubmatricesThatSumTarget target = new NumberSubmatricesThatSumTarget();
        int[][] matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(System.currentTimeMillis());
        System.out.println(target.numSubmatrixSumTarget(matrix, 3));
        System.out.println(System.currentTimeMillis());
    }

    private static void testRemoveAllAdjacentDuplicatesInString() throws IOException {
        Class clazz = Main.class;
        InputStream inputStream = clazz.getResourceAsStream("fileTest.txt");
        String data = readFromInputStream(inputStream);

        System.out.println(System.currentTimeMillis());
        String res = new RemoveAllAdjacentDuplicatesInString2().removeDuplicates("pbbcggttciiippooaais", 2);
        System.out.println(System.currentTimeMillis());
        System.out.println(res);
    }

    private static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static int calcWithoutRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int prev = 1;
        int cur = 1;
        int fib = 1;
        for (int i = 2; i < n; i++) {
            fib = prev + cur;
            prev = cur;
            cur = fib;
        }
        return fib;
    }

    private static void testPartitionList() {
        PartitionList partitionList = new PartitionList();

        ListNode node = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(-100, new ListNode(2, new ListNode(5,
                new ListNode(2)))))));

        //ListNode node = new ListNode(2, new ListNode(1));

        ListNode result = partitionList.partition(node, 3);

        System.out.println("[1,4,3,0,2,5,2]");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static void testVerifyingAlienDictionary() {
        VerifyingAlienDictionary dictionary = new VerifyingAlienDictionary();
        System.out.println(dictionary.isAlienSorted(new String[]{"asd"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(dictionary.isAlienSorted(new String[]{"aaa", "bbb", "caa"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(dictionary.isAlienSorted(new String[]{"asd", "baa"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(dictionary.isAlienSorted(new String[]{"bsd", "baa"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(dictionary.isAlienSorted(new String[]{"abc", "abcc"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(dictionary.isAlienSorted(new String[]{"abcc", "abc"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int counter = 0;
        for (int i : nums) {
            if (i == 0) {
                counter = 0;
            } else if (++counter > result) {
                result = counter;
            }
        }
        return result;
    }

    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int i : nums) {
            if ((size(i) & 1) != 1) {
                result++;
            }
        }
        return result;
    }

    static int size(int num) {
        int p = 10;
        for (int i = 1; i < 10; i++) {
            if (num < p) {
                return i;
            }
            p = 10 * p;
        }
        return p;
    }

    public static int[][] generateRandom(int rows, int cols, int min, int max) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = new Random().nextInt(min + max) - min + 1;
            }
        }

        return result;
    }
}
