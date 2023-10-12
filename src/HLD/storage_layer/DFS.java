package HLD.storage_layer;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        int vertex = 5;
        List<List<Integer>> adjacentList =
                List.of(List.of(2,3,1), List.of(0), List.of(0,4), List.of(0), List.of(2));

        System.out.println(dfsOfGraph(vertex, adjacentList));
    }

    public static List<Integer> dfsOfGraph(int vertex, List<List<Integer>> adjacentList) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visitedList = new boolean[vertex];
        visitedList[0] = true;
        dfs(0, visitedList, adjacentList, ans);
        return ans;
    }

    public static void dfs(int node, boolean[] visitedList, List<List<Integer>> adjacentList, List<Integer> ans) {
        visitedList[node] = true;
        ans.add(node);
        for (Integer i : adjacentList.get(node)) {
            if (!visitedList[i])
                dfs(i, visitedList, adjacentList, ans);
        }
    }

}
