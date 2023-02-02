package advance.dp_2.exp;

import java.util.Arrays;

public class MinSquareSum {
    public static void main(String[] args) {
        int input = 7;
        int[] dp = new int[input + 1];
        Arrays.fill(dp, -1);
        int ans = findMinSS(input, dp);
        System.out.println(ans);
    }

    private static int findMinSS(int input, int[] dp) {
        //sanity check
        if (input < 0)
            return -1;
        // dp check
        if (dp[input] != -1)
            return dp[input];

        // base case
        if (input == 0)
            return input;

        // recurrence relationship
        int min = Integer.MAX_VALUE;
        int x = (int) Math.sqrt(input);
        for (int i = x; i >= 1; i--) {
            min = Math.min(min,1 + findMinSS(input - (i * i), dp));
        }
        dp[input] = min;
        return dp[input];
    }
}
