package advance.dp_4.asg;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;

public class CuttingARod {

    public static void main(String[] args) {
        int[] A = {0, 0, 10, 3, 21, 20, 34, 30, 33, 45, 12, 1, 16, 23, 39, 56, 29};
        int ans = solve(A);
        System.out.println("Maximum profit: "+ans);
    }

    public static int solve(int[] A) {
        // initialize length array
        int[] length = new int[A.length];
        for (int i = 0; i<A.length; i++) {
            length[i] = i+1;
        }
        int maxLength = A.length;
        int N = A.length;
        // initialize dp
        int[][] dp = new int[N+1][maxLength+1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return find(A, length, dp, maxLength, N);
    }

    private static int find(int[] prices, int[] length, int[][] dp, int maxLength, int index) {
        // sanity check
        if (maxLength < 0 || index <0)
            return -1;

        // dp check
        if (dp[index][maxLength] != -1)
            return dp[index][maxLength];

        // base condition
        if (maxLength == 0 || index == 0) {
            dp[index][maxLength] = 0;
            return 0;
        }

        // recurrence relationship
        int max;
        if (length[index-1] > maxLength)
            max = find(prices, length, dp, maxLength, index-1);
        else {
            int ans1 = find(prices, length, dp, maxLength, index-1);
            int ans2 = prices[index - 1] + find(prices, length, dp, maxLength - length[index - 1], index);
            max = Math.max(ans1, ans2);
        }
        dp[index][maxLength] = max;
        return dp[index][maxLength];
    }
}
