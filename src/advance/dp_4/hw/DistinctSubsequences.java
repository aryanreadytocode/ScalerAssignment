package advance.dp_4.hw;

import java.util.Arrays;

public class DistinctSubsequences {

    public static void main(String[] args) {
        String source = "aaaababbababbaabbaaababaaabbbaaabbb";
        String target = "bbababa";
        int ans = new DistinctSubsequences().numDistinct(source, target);
        System.out.println(ans);
    }

    private int numDistinct(String A, String B) {
        int i = A.length();
        int j = B.length();
        // build dp
        int[][] dp = new int[i+1][j+1];
        for (int[] arr: dp)
            Arrays.fill(arr, -1);
        return find(A, B, i, j, dp);
    }

    private int find(String source, String target, int i, int j, int[][] dp) {
        // sanity check
        if (i < 0 || j < 0 || i > source.length() || j > target.length())
            return -1;

        // dp check
        if (dp[i][j] != -1)
            return dp[i][j];

        // base case
        if (j == 0) {
            dp[i][j] = 1;
            return dp[i][j];
        }
        if (i == 0) {
            dp[i][j] = 0;
            return dp[i][j];
        }

        // recurrence rela
        if (source.charAt(i-1) != target.charAt(j-1))
            dp[i][j] = find(source, target, i-1, j, dp);
        else {
            dp[i][j] = find(source, target, i-1, j, dp) +
                    find(source, target ,i-1, j-1, dp);
        }
        return dp[i][j];
    }
}
