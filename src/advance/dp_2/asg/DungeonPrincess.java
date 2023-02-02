package advance.dp_2.asg;

import java.util.Arrays;

public class DungeonPrincess {

    public static void main(String[] args) {
        int[][] input = {{-2, -3, 3},
                {-5, -10, 1},
        {10, 30, -5}};
        int ans = new DungeonPrincess().calculateMinimumHP1(input);
        System.out.println(ans);
    }

    public int calculateMinimumHP(int[][] A) {
        int[][] dp = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int x = 0;
        int y = 0;
        int ans = find(x, y, dp, A);
        if (ans<=0){
            ans = (ans * -1) + 1;
        }
        return ans;
    }

    private int find(int x, int y, int[][] dp, int[][] input) {
        //sanity check
        if (x < 0 || y < 0 || x >= input.length || y >= input[0].length)
            return -101;

        // dp check
        if (dp[x][y] != -1)
            return dp[x][y];

        // base case
        if (x == (input.length) - 1 && y == input[0].length - 1) {
            return Math.max(1, 1-input[x][y]);

        }

        int subAns1 = find(x + 1, y, dp, input);
        int subAns2 = find(x, y + 1, dp, input);

        dp[x][y] = Math.max(1, Math.min(subAns1, subAns2) - input[x][y]);

        return dp[x][y];
    }

    public int calculateMinimumHP1(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }
        return minH(0, 0, dp, A, N, M);
    }
    public int minH(int i, int j, int[][] dp, int[][] mat, int N, int M){
        if( i >= N || j>= M ){
            return Integer.MAX_VALUE;
        }
        if(i==N-1 && j==M-1){
            return Math.max(1, 1-mat[i][j]);
        }
        if(dp[i][j]==-1){
            int a = minH(i+1, j, dp, mat, N, M);
            int b = minH(i, j+1, dp, mat, N, M);
            dp[i][j] = Math.max(1, Math.min(a, b) - mat[i][j]);
        }
        return dp[i][j];
    }
}
