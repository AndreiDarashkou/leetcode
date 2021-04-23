package challenge.april;

import challenge.april.common.ListNode;
import challenge.april.common.NestedIntegerImpl;
import challenge.april.week2.DeepestLeavesSum;
import challenge.april.week2.FlattenNestedListIterator;
import challenge.april.week2.LetterCombinations;
import challenge.april.week2.LongestIncreasingPathInMatrix;
import challenge.april.week2.NestedInteger;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static challenge.april.week2.DeepestLeavesSum.TreeNode;

public class Main {

    public static void main(String[] args) throws IOException {
        //testVerifyingAlienDictionary();
        //testLongestIncreasingPathInMatrix();
        //testLetterCombinations();
        testDeepestLeavesSum();
        //testFlattenNestedListIterator();
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

    private static void testFlattenNestedListIterator() {
        List<NestedInteger> nestedList = new ArrayList<>();

        nestedList.add(new NestedIntegerImpl(List.of(new NestedIntegerImpl((Integer) null))));

        nestedList.add(new NestedIntegerImpl(5));
        nestedList.add(new NestedIntegerImpl(6));

        List<NestedInteger> nestedList2 = new ArrayList<>();
        nestedList2.add(new NestedIntegerImpl(1));
        nestedList2.add(new NestedIntegerImpl(2));
        nestedList2.add(new NestedIntegerImpl(3));
        nestedList.add(new NestedIntegerImpl(nestedList2));

        nestedList.add(new NestedIntegerImpl(8));

        List<NestedInteger> nestedList3 = new ArrayList<>();
        nestedList3.add(new NestedIntegerImpl(12));
        nestedList3.add(new NestedIntegerImpl(13));
        nestedList3.add(new NestedIntegerImpl(14));

        nestedList3.add(new NestedIntegerImpl(List.of(new NestedIntegerImpl(890), new NestedIntegerImpl(555),
                new NestedIntegerImpl(List.of(new NestedIntegerImpl(-777))))));

        nestedList.add(new NestedIntegerImpl(nestedList3));

        nestedList.add(new NestedIntegerImpl(99));

        FlattenNestedListIterator iterator = new FlattenNestedListIterator(nestedList);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
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

    private static void testLongestIncreasingPathInMatrix() {
        LongestIncreasingPathInMatrix pathInMatrix = new LongestIncreasingPathInMatrix();
        int path1 = pathInMatrix.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
        System.out.println(path1);

        path1 = pathInMatrix.longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}});
        System.out.println(path1);

        path1 = pathInMatrix.longestIncreasingPath(new int[][]{{1, 2, 3}, {6, 5, 4}, {7, 8, 9}});
        System.out.println(path1);

        path1 = pathInMatrix.longestIncreasingPath(new int[][]{{5, 7, 10, 9}, {1, 2, 3, 7}, {9, 4, 2, 7}, {8, 8, 5, 3}});
        System.out.println(path1);

        int path2 = pathInMatrix.longestIncreasingPath(new int[][]{{7, 7, 5}, {2, 4, 6}, {8, 2, 0}});
        System.out.println(path2);

        int[][] matrix = generateRandom(200, 100, 0, Integer.MAX_VALUE);
        long st = System.currentTimeMillis();
        int path = pathInMatrix.longestIncreasingPath(matrix);
        long end = System.currentTimeMillis();
        System.out.println(end - st);
    }

    private static void testDeepestLeavesSum() {
        TreeNode node4 = new TreeNode(4, new TreeNode(7), null);
        TreeNode node2 = new TreeNode(2, node4, new TreeNode(5));

        TreeNode node6 = new TreeNode(6, null, new TreeNode(8));
        TreeNode node3 = new TreeNode(3, null, node6);

        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(DeepestLeavesSum.deepestLeavesSum(node1));
    }

    private static void testLetterCombinations() {
        LetterCombinations combinations = new LetterCombinations();
        System.out.println(combinations.letterCombinations("234"));
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
