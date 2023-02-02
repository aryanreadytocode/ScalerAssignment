package advance.dp_2.exp;

import java.util.Arrays;

/*
* Given N number of houses. Figure out the maximum loot possible such
* you don't loot any 2 consecutive houses*/
public class MaxLoot {

    public static void main(String[] args) {
        int[] input = {2, 13, 2, 50, 100, 1};
        int[] dp = new int[input.length];
        Arrays.fill(dp, -1);
        int ans = findMaxLoot(input, dp, input.length-1);
        System.out.println("Max loot : "+ans);
    }

    private static int findMaxLoot(int[] input, int[] dp, int index) {
        // sanity check
        if (index < 0 || index >= input.length) {
            return -1;
        }

        // dp check
        if (dp[index] != -1)
            return dp[index];

        // base condition
        if (index == 0) {
            dp[index] = input[index];
            return dp[index];
        }else if (index == 1) {
            dp[index] = Math.max(input[0], input[1]);
            return dp[index];
        }

        // recurrence relationship
        int sub1 = findMaxLoot(input, dp, index-1);
        int sub2 = input[index] + findMaxLoot(input, dp, index-2);

        int max = Math.max(sub1, sub2);
        dp[index] = max;
        return dp[index];
    }
}
