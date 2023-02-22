package advance.dp_4.exp;

import java.util.Arrays;

/**
 * check substring from given string is palindrom and return 2d array with index and palindrom or not*/
public class SubstringPalindrom {

    public static void main(String[] args) {
        String s = "abacbca";
        // initialize dp
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        // fill value
        for (Boolean[] arr : dp){
            Arrays.fill(arr, null);
        }
        for (int i = 0; i<s.length(); i++) {
            for (int j = i; j<s.length(); j++) {
                findPal(i, j, s, dp);
            }
        }
        for (Boolean[] r : dp) {
            System.out.println(Arrays.toString(r));
        }

    }

    private static Boolean findPal(int i, int j, String s, Boolean[][] dp) {
        // sanity check
        if (i<0 || j>=s.length() || i>j)
            return true;

        // dp check
        if (dp[i][j] != null)
            return dp[i][j];

        // base case
        if (i == j) {
            dp[i][j] = true;
            return true;
        }
        // recurrence relationship
        if (s.charAt(i) != s.charAt(j))
            return false;
        dp[i][j] = findPal(i+1, j-1, s, dp);

        return dp[i][j];
    }

}
