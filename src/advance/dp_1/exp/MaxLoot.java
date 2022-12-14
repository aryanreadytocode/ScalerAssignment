package advance.dp_1.exp;

import java.util.Arrays;

/*
* Given N houses, figure out the max loot possible such that you don't loot two consecutive
* houses*/
public class MaxLoot {

    static int[] dpArr;
    public static void main(String[] args) {

        int[] houses = {6,10,99,3};
        int index = houses.length;
        dpArr = new int[index+1];
        Arrays.fill(dpArr, -1);
        int ans = solve(houses, index-1);
        System.out.println(ans);
    }

    private static int solve(int[] houses, int input) {
        // sanity check
        if (input < 0 || input > houses.length)
            return -1;

        // dp check if the value is already evaluated
        if (dpArr[input] != -1)
            return dpArr[input];

        // base case
        if (input == 0) {
            dpArr[input] = houses[input];
            return dpArr[input];
        }
        if (input == 1) {
            dpArr[input] = houses[input];
            return dpArr[input];
        }

        // recurrence relationship
        int subProblem1 =  solve(houses,input - 1);
        int subProblem2 = solve(houses,input-2);
        int maxi = Math.max(subProblem1 , subProblem2+houses[input]);
        dpArr[input] = maxi;
        return maxi;
    }


}
