package advance.dp_2.hw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LetParty {

    public static void main(String[] args) {
        int input = 17;
        int ans = new LetParty().solve(input);
        System.out.println(ans);
    }
    int mod = 10003;

    public int solve(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);
        return find(A, dp);
    }

    private int find(int input, int[] dp) {
        //sanity check
        if (input <= 0)
            return 0;
        //dp check
        if (dp[input] != -1)
            return dp[input];
        //base condition
        if (input == 1 || input == 2) {
            dp[input] = input;
            return input;
        }

        // recurrence relationship
        int ways = (find(input - 1, dp)%mod + find(input - 2, dp)%mod * (input - 1)%mod)%mod;
        dp[input] = ways;
        return dp[input];
    }
}
