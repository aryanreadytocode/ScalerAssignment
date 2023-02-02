package advance.dp_3.hw;

import java.util.Arrays;

public class TusharBirthdayParty {

    public static void main(String[] args) {
        int[] friends = {2, 4, 6};
        int[] dishes = {2, 1, 3};
        int[] costs = {2, 5, 3};
        int minCost = new TusharBirthdayParty().solve(friends, dishes, costs);
        System.out.println(minCost);
    }

    public int solve(final int[] A, final int[] B, final int[] C) {
        // find maximum eating capacity of friend
        int maxEatingCap = 0;
        for (int i : A) {
            maxEatingCap = Math.max(i, maxEatingCap);
        }

        // declare dp and initialize with -1 which store minimum cost;
        int[][] dp = new int[A.length+1][maxEatingCap+1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        long ans = 0;
        for (int k = 0; k < A.length; k++) {
            ans += find(B, C, dp, A[k], B.length);
        }

        return (int) ans;
    }

    private int find(int[] dishes, int[] costs, int[][] dp, int maxEatingCap, int index) {

        //dp check
        if (dp[index][maxEatingCap] != -1) {
            return dp[index][maxEatingCap];
        }

        // base case
        if (index == 0) {
            dp[index][maxEatingCap] = 1000000000;
            return 1000000000;
        }
        if (maxEatingCap == 0) {
            dp[index][maxEatingCap] = 0;
            return 0;
        }

        // recurrence relationship
        // we have to three choices to make
        // consider item at index
        // consider same index item
        // don't consider
        int min = 0;
        if (maxEatingCap < dishes[index-1])
            dp[index][maxEatingCap] = find(dishes, costs, dp, maxEatingCap, index-1);
        else {
            int exclude = find(dishes, costs, dp, maxEatingCap, index-1) ;
            int include = find(dishes, costs, dp, maxEatingCap-dishes[index-1], index) + costs[index-1];
            dp[index][maxEatingCap] = Math.min(include, exclude);
        }
        return dp[index][maxEatingCap];
    }
}
