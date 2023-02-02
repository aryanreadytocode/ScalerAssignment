package advance.dp_2.asg;

import java.util.Arrays;

public class UniquePathsInAGrid {

    public static void main(String[] args) {
        int[][] input = {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
        };
        int[][] dp = new int[input.length][input[0].length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int maxAns = findMaxUniquePath(input, dp, 0, 0);
        System.out.println("Max Unique path: "+maxAns);
    }

    private static int findMaxUniquePath(int[][] input, int[][] dp, int x, int y) {
        // sanity check
        if (x >= input.length || x < 0 || y >= input[0].length || y < 0) {
            return 0;
        }

        // dp check
        if (dp[x][y] != -1)
            return dp[x][y];

        // base condition
        if (input[x][y] == 1)
            return 0;

        if (x == input.length-1 && y == input[0].length-1) {
            dp[x][y] = 1;
            return 1;
        }


        // recurrence relationship
        int path1 = findMaxUniquePath(input, dp, x+1, y);
        int path2 = findMaxUniquePath(input, dp, x, y+1);
        dp[x][y] = path1+path2;
        return dp[x][y];
    }
}
