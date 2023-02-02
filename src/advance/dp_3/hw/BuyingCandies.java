package advance.dp_3.hw;

import java.util.Arrays;

public class BuyingCandies {

    public static void main(String[] args) {
        int[] A = {2};
//        int[] A = {1, 2, 3};
        int[] B = {5};
//        int[] B = {2, 2, 10};
        int[] C = {10};
//        int[] C = {2, 3, 9};
        int D = 99;
//        int D = 8;
        int maxSweetness = new BuyingCandies().solve(A, B, C, D);
        System.out.println("Max sweet: "+maxSweetness);
    }

    public int solve(int[] A, int[] B, int[] C, int D) {
        int[][] dp = new int[C.length+1][D+1];
        for (int[] arr: dp) {
            Arrays.fill(arr,-1);
        }
        return find(A, B, C, D, A.length, dp);
    }

    private int find(int[] items, int[] sweetness, int[] cost, int money, int index, int[][] dp) {
        // base case
        if (money < 0 || index < 0 || index > items.length)
            return -1;

        // dp check
        if (dp[index][money] != -1)
            return dp[index][money];

        // base case
        if (index == 0 || money == 0) {
            dp[index][money] = 0;
            return 0;
        }

        // recurrence relationship
        // if left money is less that cost of chocolate packet at given index
        // then we will not consider that chocolate to buy;
        int ans;
        if (money < cost[index-1])
            ans = find(items, sweetness, cost, money, index-1, dp);
        else {
            // three cases would be there
            // consider the item
            // don't consider the item
            // consider same item again
            // max sweet = sweet of 1 candy * no of candy
            int a1 = find(items, sweetness, cost, money, index-1, dp);
            int a3 = sweetness[index-1] * items[index-1] + find(items, sweetness, cost, money-cost[index-1], index, dp);
            ans = Math.max(a1, a3);
        }
        dp[index][money] = ans;
        return dp[index][money];
    }
}
