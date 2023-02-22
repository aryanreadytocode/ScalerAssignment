package advance.dp_4.asg;

import java.util.Arrays;

public class Zero_1KnapsackII {

    public static void main(String[] args) {
//        int[] values = {8,5,50,40};
        int[] values = {6, 10, 12};
//        int[] weight = {1,20,30,3};
        int[] weight = {10, 20, 30};
//        int sum = 27;
        int sum = 50;
        int ans = new Zero_1KnapsackII().solve1(values, weight, sum);
        System.out.println(ans);
    }

    private int solveNative(int[] values, int[] weight, int sum) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i<values.length; i++) {
            int wt = 0;
            int pf = 0;
            for (int j = i; j<values.length; j++) {
                wt += weight[j];
                pf += values[j];
                if (wt <= sum) {
                    maxProfit = Math.max(maxProfit, pf);
                }
            }

        }
        return maxProfit;
    }

    private int solve1(int[] values, int[] weight, int sum) {
        // As we can see here sum>=1e6 and size of array can be 500
        // so TC would become large
        // so we will consider value array whose max value of each element can be 50
        // so max value can be pich 50*500
        int n = values.length;
        int maxValues = 0;
        for (int value : values) {
            maxValues += value;
        }

        // build dp
        int[] dp = new int[maxValues+1];
        dp[0] = 0;
        for (int i = 1; i < maxValues+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i< n; i++) {
            for (int j = maxValues; j>=values[i]; j--) {
                int second = dp[j-values[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : weight[i] + dp[j-values[i]];
                dp[j] = Math.min(dp[j], second);
            }
        }
        int ans = 0;
        for (int i = maxValues; i>=0; i--) {
            if (dp[i] <= sum) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    private int solve(int[] values, int[] weight, int sum) {
        // create dp
        int[][] dp = new int[values.length+1][50*500+1];
        //initialize dp
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return find(values, weight, dp, sum, values.length);
    }

    private int find(int[] values, int[] weight, int[][] dp, int sum, int index) {
        // sanity check
        if (index < 0 || index > weight.length || sum < 0)
            return Integer.MIN_VALUE;

        // dp check
        if (dp[index][sum] != -1)
            return dp[index][sum];

        // base case condition check
        if (sum == 0 || index == 0) {
            dp[index][sum] = 1;
            return 0;
        }

        // recurrence relationship
        int result;
        if (weight[index-1] > sum)
            result = find(values, weight, dp, sum, index - 1);
        else {
            result = Math.max(find(values, weight, dp, sum, index-1),
                    values[index-1]+ find(values, weight, dp, sum-weight[index-1], index-1));
        }
        dp[index][sum] = result;
        return dp[index][sum];
    }
}
