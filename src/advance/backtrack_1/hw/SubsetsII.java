package advance.backtrack_1.hw;

import java.util.*;

public class SubsetsII {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1); input.add(2); input.add(3);
        ArrayList<ArrayList<Integer>> ans = subsetsWithDup(input);
        System.out.println(ans);

    }

    // we'll use bfs to get the subset
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        return null;
    }
}
