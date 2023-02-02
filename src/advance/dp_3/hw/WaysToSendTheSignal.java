package advance.dp_3.hw;

public class WaysToSendTheSignal {

    public static void main(String[] args) {
        int A = 3;
        int ans = new WaysToSendTheSignal().solve(A);
        System.out.println(ans);
    }
    int mod = 109+7;
    public int solve(int A) {
        // prepare dp to max possible signal

        int[][] dp = new int[2][A+1];

        // at 0 position max possible signal would be zero
        dp[0][0] = 0; // for on at zero light
        dp[1][0] = 0; // for off at zero light

        // at 1 position max possible signal would be 1 either on or off
        dp[0][1] = 1; // on
        dp[1][1] = 1; // off

        // for off signal two possibilities
        for (int j = 2; j<dp[0].length; j++) {
                    dp[0][j] = (dp[0][j-1]%mod+dp[1][j-1]+mod)%mod;
                    dp[1][j] = dp[0][j-1]%mod;
        }

        return (dp[0][dp[0].length-1] %mod + dp[1][dp[0].length-1]%mod)%mod;
    }
}
