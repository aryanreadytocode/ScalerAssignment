package advance.dp_2.asg;

public class NDigitNumbers {
    public int[][] dp = new int[1001][10001];
    public static void main(String[] args) {
        int A = 10;
        int B = 85;
        int ans = new NDigitNumbers().solve(A, B);
        System.out.println(ans);
    }

    public  int solve(int A, int B) {
        int ans = 0;
        for (int i = 0; i < A + 1; i++) {
            for (int j = 0; j < B + 1; j++)
                dp[i][j] = -1;
        }
        for (int i = 1; i < 10; i++) {
            ans += findMax(A - 1, B - i);
            ans %= 1000000007;
        }
        return ans;
    }

    private int findMax(int digit, int sum) {
        // sanity check
        if (sum < 0 || digit < 0)
            return 0;

        // dp check
        if (dp[digit][sum] != -1)
            return dp[digit][sum];

        // base case
        if (digit == 0 && sum == 0)
            return 1;
        if (digit == 0)
            return 0;

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += findMax(digit - 1, sum - i);
            ans %= 1000000007;
        }
        return dp[digit][sum] = ans;
    }

    public static int solveNaive(int A, int B) {
        int count = 0;
        int mod = 1000000007;
        int start = (int) Math.pow(10, A-1);
        int end = (int) Math.pow(10, A) - 1;
        for(int i = start; i < end; i++) {
            int sum = 0;
            int temp = i;
            for (int j = 0; j < A; j++) {
                sum += temp % 10;
                if (sum > B)
                    continue;
                temp /= 10;
            }
            if ( sum == B)
                count = (count+1)%mod;
        }
        return count;
    }
}
