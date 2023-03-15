package advance.dp_5.asg;

import java.util.Arrays;

// find minimum number of partition required to make a
// String palindrome
// ex- aaaaa >> 0
// ex- a|b|c|d|e >> 4
// ex- abba|c >> 1
public class PalindromicSubsequence {

    public static void main(String[] args) {
        String A = "abbac";
        int ans = solve(A);
        System.out.println(ans);
    }

    private static int solve(String A) {
        // first prepare dp for palindrome
        int N = A.length();
        Boolean[][] dpPalindrom = new Boolean[N][N];
        for (Boolean[] arr: dpPalindrom) {
            Arrays.fill(arr, null);
        }
        for (int i = 0; i<N; i++) {
            for (int j = i; j<N; j++) {
                findPal(i, j, A, dpPalindrom);
            }
        }
        // now create dp for minimum partition to make String palindrome
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return getMinCount(A, N-1, dp, dpPalindrom);

    }

    private static int getMinCount(String a, int n, int[] dp, Boolean[][] dpPalindrom) {
        // sanity check
        if (n < 0 )
            return 0;
        if (n>=a.length())
            return Integer.MAX_VALUE;
        // dp check
        if (dp[n] != -1)
            return dp[n];

        // base case
        if (dpPalindrom[0][n]!=null && dpPalindrom[0][n]) {
            dp[n] = 0;
            return 0;
        }

        // recurrence relationship
        int min = Integer.MAX_VALUE;
        for (int j = 1; j<=n; j++) {
            if (dpPalindrom[j][n]!=null && dpPalindrom[j][n])
                min = Math.min(min, 1+ getMinCount(a, j-1, dp, dpPalindrom));
        }
        dp[n] = min;
        return dp[n];
    }

    private static Boolean findPal(int i, int j, String S, Boolean[][] dpPalindrom) {
        // sanity check
        if (i < 0 || j >= S.length() || i>j) {
            return true;
        }

        // dp check
        if (dpPalindrom[i][j] != null)
            return dpPalindrom[i][j];

        // base case
        if (i==j) {
            dpPalindrom[i][j] = true;
            return true;
        }

        // recurrence relationship
        if (S.charAt(i) != S.charAt(j)) {
            return false;
        }
        dpPalindrom[i][j] = findPal(i+1, j-1, S, dpPalindrom);
        return dpPalindrom[i][j];
    }
}
