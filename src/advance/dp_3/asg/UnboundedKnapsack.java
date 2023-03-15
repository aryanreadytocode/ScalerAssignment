package advance.dp_3.asg;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int A = 10;
        int[] B = {6,5};
        int[] C = {5,4};
        int ans = new UnboundedKnapsack().solve(A, B, C);
        System.out.println(ans);
    }

    public int solve(int A, int[] B, int[] C) {
        // create dp array to store maximum profit
        int[][] dp = new int[B.length+1][A+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        int index = B.length;
        return find(A, B, C, dp, index);
    }

    private int find(int leftWt, int[] profit, int[] wt, int[][] dp, int index) {
        // sanity check
        if (index < 0 || index >profit.length || leftWt < 0)
            return -1;
        // dp check
        if (dp[index][leftWt] != -1)
            return dp[index][leftWt];

        // base case
        if (index == 0 || leftWt == 0) {
            dp[index][leftWt] = 0;
            return 0;
        }

        int max = 0;
        // recurrence relationship
        if (wt[index-1] > leftWt) {
            max = find(leftWt, profit, wt, dp, index-1);
        } else {
            // don't consider item at index
            int subans1 = find(leftWt, profit, wt, dp, index-1);
            // consider same item at index recursively
            int subans2 = profit[index-1] + find(leftWt-wt[index-1], profit, wt, dp, index);
            // consider next element

            max = Math.max(subans1, subans2);
        }
        dp[index][leftWt] = max;
        return dp[index][leftWt];
    }
}
