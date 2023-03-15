package advance.dp_4.asg;

import java.util.Arrays;

public class CoinSumInfinite {

    public static void main(String[] args) {
        int[] A = {1,2,3};
        int B = 4;
        int ans = new CoinSumInfinite().solve(A, B);
        System.out.println(ans);
    }
    int mod = 1000000 + 7;
    int solve(int[] coins, int sum) {
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
            dp[index][coins[index]] = (ways%mod + 1)%mod;
            return dp[index][coins[index]];
        }

        // recurrence relationship
        int ans;

        int ans1 = find(coins, sum, index - 1, dp, ways)%mod;
        int ans2 = find(coins, sum - coins[index], index, dp, ways)%mod;
        ans = (ans1 + ans2)%mod;

        dp[index][sum] = ans;
        return ans;
    }
}
