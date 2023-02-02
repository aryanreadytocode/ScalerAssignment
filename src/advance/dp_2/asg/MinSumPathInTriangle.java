package advance.dp_2.asg;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {

    public static void main(String[] args) {
        ArrayList<Integer> cl = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pl = new ArrayList<>();
        cl.add(3,2);
        pl.add(cl);
        cl = new ArrayList<>();
        cl.add(3);
        cl.add(4);
        pl.add(cl);
        cl = new ArrayList<>();
        cl.add(6);
        cl.add(5);
        cl.add(7);
        pl.add(cl);
        cl = new ArrayList<>();
        cl.add(4);
        cl.add(1);
        cl.add(8);
        cl.add(3);
        pl.add(cl);
        int ans = new MinSumPathInTriangle().minimumTotal(pl);
        System.out.println(ans);
    }
    int yIndex;
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[] dp = new int[a.size()];
        Arrays.fill(dp, -1);
        int index = a.size() - 1;
        int yIndex = 0;
        return findMinPath(a, dp, index);
    }

    private int findMinPath(ArrayList<ArrayList<Integer>> input, int[] dp, int index) {
        if (index >= input.size() || index < 0)
            return 0;

        // dp check i
        if (dp[index] != -1)
            return dp[index];

        int minPath = findMinPath(input, dp, index - 1);
        int mini = Integer.MAX_VALUE;
        for (int i = Math.max(yIndex - 1, 0); i < Math.min(yIndex+1, input.get(index).size()); i++) {
            if (mini > input.get(index).get(i)) {
                mini = input.get(index).get(i);
                yIndex = i;
            }
        }
        dp[index] = mini + minPath;
        return dp[index];
    }
}
