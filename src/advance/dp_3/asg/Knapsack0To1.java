package advance.dp_3.asg;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack0To1 {
    public static void main(String[] args) {
//        int[] A = {60, 100, 120};
        int[] A = {359, 963, 465, 706, 146, 282, 828, 962, 492};
//        int[] B = {10, 20, 30};
        int[] B = {96, 43, 28, 37, 92, 5, 3, 54, 93};
//        int C = 50;
        int C = 383;
        int ans = new Knapsack0To1().solve(A, B, C);
        System.out.println(ans);
    }

    private static int solveNaive(int[] A, int[] B, int C) {
        int maxi = 0;
        int valueSum = 0;
        int weightSum = 0;
        for (int i = 0 ; i < A.length; i++) {
            weightSum = B[i];
            valueSum = A[i];
            for (int j = 0; j<B.length; j++) {
                if (i == j)
                    continue;
                if (weightSum + B[j] <= C) {
                    if (maxi < valueSum + A[j]){
                        maxi = valueSum + A[j];
                        valueSum = maxi;
                        weightSum += B[j];
                        System.out.println("WrightSum "+weightSum);
                        System.out.println("valueSum "+valueSum);

                    }else
                        continue;

                }
            }
        }
        return maxi;
    }

    public int solve(int[] values, int[] weights, int C) {
        int[][] dp = new int[values.length+1][C+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return find(values, weights, C, values.length, dp);
    }

    private int find(int[] profit, int[] weights, int spaceLeft, int index, int[][] dp) {
        // sanity check
        if (index < 0 || index >profit.length || spaceLeft < 0)
            return -1;

        // dp check
        if (dp[index][spaceLeft] != -1)
            return dp[index][spaceLeft];

        // base case
        // if no of items left zero or
        // space left in bag zero then max profit would become zero
        if (spaceLeft == 0 || index == 0) {
            dp[index][spaceLeft] = 0;
            return 0;
        }

        // recurrence relationship
        int result = 0;
        if (weights[index-1] > spaceLeft)
            result = find(profit, weights, spaceLeft, index-1, dp);
        else {
            result = Math.max(
                    find(profit, weights, spaceLeft, index-1, dp),
                    profit[index-1] + find(profit, weights, spaceLeft-weights[index-1], index-1, dp)
            );
        }
        dp[index][spaceLeft] = result;
        return dp[index][spaceLeft];
    }
}
