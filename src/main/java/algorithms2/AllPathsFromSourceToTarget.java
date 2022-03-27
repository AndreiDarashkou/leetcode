package algorithms2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        find(graph, 0, graph.length - 1, new ArrayList<>(), result);

        return result;
    }

    private void find(int[][] graph, int node, int target, List<Integer> subPath, List<List<Integer>> result) {
        subPath.add(node);
        for (int connection : graph[node]) {
            if (connection == target) {
                ArrayList<Integer> path = new ArrayList<>(subPath);
                path.add(target);
                result.add(path);
            } else {
                find(graph, connection, target, new ArrayList<>(subPath), result);
            }
        }
    }
}
