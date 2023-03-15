package advance.dp_5.asg;

import java.util.Arrays;

/*given two number N, K. Find the count of all N-digit no
* with the sum of it/'s digit = sum*/
public class NDigitSum {

    public static void main(String[] args) {
        int sum = 1;
        int digit = 3;
        int ans = solve(sum, digit);
        System.out.println(ans);
    }

    private static int solve(int sum, int digit) {
        // prepare dp
        int[][] dp = new int[digit+1][sum+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return (find(sum, digit, dp)-find(sum, digit-1, dp));
    }

    private static int find(int sum, int digit, int[][] dp) {
        // sanity check
        if (digit < 0 || sum<0)
            return 0;

        // dp check
        if (dp[digit][sum] != -1)
            return dp[digit][sum];

        // base case
        if (digit == 0) {
            if (sum==0)
                dp[digit][sum] = 1;
            else
                dp[digit][sum] = 0;

            return dp[digit][sum];
        } else if (digit == 1) {
            if (sum<=9)
                dp[digit][sum] = 1;
            else
                dp[digit][sum] = 0;
            return dp[digit][sum];
        }

        // recurrence relationship
        int ans = 0;
        for (int i = 0; i<10; i++) {
            ans += find(sum-i, digit-1,dp);
        }
        dp[digit][sum] = ans;
        return dp[digit][sum];
    }
}
