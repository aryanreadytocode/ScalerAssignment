package advance.dp_2.hw;

import advance.dp_2.asg.MinSumPathInTriangle;

import java.util.Arrays;

public class MinSumPathInMatrix {

    public static void main(String[] args) {
        int[][] input = {{1, 3, 2}, {4, 3, 1}, {5, 6, 1}};
        int ans = new MinSumPathInMatrix().minPathSum(input);
        System.out.println(ans);
    }

    public int minPathSum(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;
        int[][] dp = new int[rowSize][colSize];
        for (int i = 0; i<rowSize; i++) {
            Arrays.fill(dp[i], -1);
        }
        return find(0,0,dp, A);
    }

    private int find(int x, int y, int[][] dp, int[][] input) {
        // base case
        if (x < 0 || y< 0 | x >= input.length | y>= input[0].length)
            return Integer.MAX_VALUE;

        // dp check
        if (dp[x][y] != -1)
            return dp[x][y];

        // base case
        if (x == input.length-1 & y == input[0].length-1){
            dp[x][y] = input[x][y];
            return dp[x][y];
        }

        // recurrence relationship
        int subAns1 = find(x+1, y, dp, input);
        int subAns2 = find(x, y+1, dp, input);

        int ans = Math.min(subAns1, subAns2) + input[x][y];
        dp[x][y] = ans;
        return dp[x][y];
    }
}
