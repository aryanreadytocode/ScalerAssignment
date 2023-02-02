package advance.dp_4.exp;

import java.util.Arrays;

public class CoinsSum {

    public static void main(String[] args) {
        int[] coins = {4, 5, 3};
        int sum = 4;
        int ans = new CoinsSum().maxSum(coins, sum);
        System.out.println(ans);
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
        if (sum == 0 && index >= 0) {
            dp[index][coins[index - 1]] = ways + 1;
            return dp[index][coins[index - 1]];
        }

        // recurrence relationship
        int ans = 0;

        int ans1 = find(coins, sum, index - 1, dp, ways);
        int ans2 = find(coins, sum - coins[index], index, dp, ways);
        ans = ans1 + ans2;

        dp[index][sum] = ans;
        return ans;
    }
}
