package advance.dp_1.asg;

import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
    public static void main(String[] args) {
        int[][] input =
                {
                        {2, 6, 6, 1, 16, 6, 15},
                        {9, 16, 5, 4, 20, 3, 3}
                };
        int[] dpArr = new int[input[0].length + 1];
        Arrays.fill(dpArr, -1);
        int ans = adjacent1(input);
        System.out.println(ans);
    }

    private static int adjacent(int[][] input, int index, int[] dpArr) {
        //sanity check
        if (index < 0 || index > input[0].length)
            return 0;
        // dp check
        if (dpArr[index] != -1)
            return dpArr[index];

        // base condition
        if (index == 0) {
            int max = Math.max(input[0][index], input[1][index]);
            dpArr[index] = max;
            return max;
        }
        // base condition
        if (index == 1) {
            int max1 = Math.max(input[0][index - 1], input[1][index - 1]);
            int max2 = Math.max(input[0][index], input[1][index]);
            int finalMax = Math.max(max1, max2);
            dpArr[index] = finalMax;
            return finalMax;
        }

        // recurrence relationship
        int maxi = Integer.MIN_VALUE;
        for (int i = index; i >= 0; i--) {
            int sum1 = adjacent(input, i - 2, dpArr);
            int sum2 = Math.max(input[0][i], input[1][i]);
            int finalSum = 0;
            if (sum1 > 0 && sum2 > 0) {
                finalSum = sum1 + sum2;
            } else if (sum1 < 0)
                finalSum = sum2;
            else
                finalSum = sum1;

            maxi = Math.max(maxi, finalSum);
        }
        dpArr[index] = maxi;
        return maxi;
    }

    public static int adjacent1(int[][] A) {

        int[][] input = A;

        int[] dpArr = new int[input[0].length + 1];

        Arrays.fill(dpArr, -1);

        return solve1(input, input[0].length - 1, dpArr);

    }

    private static int solve1(int[][] input, int index, int[] dpArr) {

        //sanity check

        if (index < 0 || index > input[0].length)

            return 0;

        // dp check

        if (dpArr[index] != -1)

            return dpArr[index];

        // base condition

        if (index == 0) {

            int max = Math.max(input[0][index], input[1][index]);

            dpArr[index] = max;

            return max;

        }

        //base condition

        if (index == 1) {

            int max1 = Math.max(input[0][index - 1], input[1][index - 1]);

            int max2 = Math.max(input[0][index], input[1][index]);

            int finalMax = Math.max(max1, max2);

            dpArr[index] = finalMax;

            return finalMax;

        }

        // recurrence relationship

        int maxi = Integer.MIN_VALUE;

        int sum1 = solve1(input, index - 2, dpArr) + Math.max(input[0][index], input[1][index]);

        int sum2 = solve1(input, index - 1, dpArr);

        maxi = Math.max(sum1, sum2);

        dpArr[index] = maxi;

        return maxi;

    }
}
