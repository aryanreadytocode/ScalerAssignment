package advance.dp_4.exp;

import java.util.Arrays;

public class CoinsSum {

    public static void main(String[] args) {
        int[] coins = {4, 5, 3};
        int sum = 12;
        int ans = new CoinsSum().maxSumBottomUp(coins, sum);
        System.out.println(ans);
    }

    public int maxSumBottomUp(int[] coins, int sum) {
        // initialize dp
        int[][] dp = new int[coins.length][sum+1];
        // initialize column
        int j = 0;
        for (int i = 0; i<coins.length; i++) {
            dp[i][j] = 0;
        }
        // initialize 0th-row
        int i = 0;
        for (j = 1; j<= sum; j++) {
            if (coins[i] % j == 0)
                dp[i][j] = 1;
            else
                dp[i][j] = 0;
        }
        for (i = 1; i<coins.length; i++) {
            for (j = 1; j<=sum; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[j]];
            }
        }
        return dp[coins.length-1][sum];

    }

    public int maxSum(int[] coins, int sum) {
        int[][] dp = new int[coins.length][sum + 1];
        int index = coins.length;
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return find(coins, sum, index - 1, dp, 0);
    }

    private int find(int[] coins, int sum, int index, int[][] dp, int ways) {
        // sanity check
        if (sum < 0 || index < 0)
            return 0;

        // dp check
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        // base case
        if (sum == 0) {
            dp[index][coins[index]] = ways + 1;
            return dp[index][coins[index]];
        }

        // recurrence relationship
        int ans;

        int ans1 = find(coins, sum, index - 1, dp, ways);
        int ans2 = find(coins, sum - coins[index], index, dp, ways);
        ans = ans1 + ans2;

        dp[index][sum] = ans;
        return ans;
    }
}
