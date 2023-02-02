package advance.dp_4.exp;

import java.util.ArrayList;
import java.util.Arrays;

public class StringMatching {

    public static void main(String[] args) {
        int Add = 2;
        int Mod = 5;
        int del = 1;
        String source = "r";
        String target = "ra";
        int totalCost = findMinimumCostTopDown(Add, Mod, del, source, target);
        System.out.println("Total Cost:" + totalCost);
    }

    private static int findMinimumCostBottomUp(int add, int mod, int del, String source, String target) {
        return 0;
    }


    private static int findMinimumCostTopDown(int add, int mod, int del, String source, String target) {
        int[][] dp = new int[source.length()][target.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int i = source.length();
        int j = target.length();
        return find(add, mod, del, source, target, dp, i - 1, j - 1);
    }

    private static int find(int add, int mod, int del, String source, String target, int[][] dp, int i, int j) {
        // sanity check
        if (i < 0 || j < 0 || i > source.length() || j > target.length()) {
            return 0;
        }

        // dp check
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // base case
        if (i == 0 && j == 0) {
            if (source.charAt(i) == target.charAt(j)) {
                dp[i][j] = 0;
            } else {
                int modCost = mod + find(add, mod, del, source, target, dp, i - 1, j - 1);
                int delCost = del + find(add, mod, del, source, target, dp, i - 1, j);
                int addCost = add + find(add, mod, del, source, target, dp, i, j - 1);
                int min = Math.min(modCost, delCost);
                min = Math.min(min, addCost);
                dp[i][j] = min;
            }
            return dp[i][j];
        }

        // recurrence relationship
        if (source.charAt(i) == target.charAt(j)) {
            dp[i][j] = find(add, mod, del, source, target, dp, i - 1, j - 1);
        } else {
            int modCost = mod + find(add, mod, del, source, target, dp, i - 1, j - 1);
            int delCost = del + find(add, mod, del, source, target, dp, i - 1, j);
            int addCost = add + find(add, mod, del, source, target, dp, i, j - 1);
            int min = Math.min(modCost, delCost);
            min = Math.min(min, addCost);
            dp[i][j] = min;
        }
        return dp[i][j];
    }
}
