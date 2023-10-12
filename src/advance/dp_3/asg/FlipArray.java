package advance.dp_3.asg;


import java.lang.reflect.Parameter;
import java.util.*;

public class FlipArray {

    public static void main(String[] args) {
        int[] A1 = {15, 10, 6};
        List<Integer> A = new ArrayList<>();
        for (int i : A1) {
            A.add(i);
        }
        int ans = new FlipArray().solve1(A1);
        System.out.println(ans);
    }

    public int solve1(final int[] A) {

        int sum = 0;
        for(int val : A){
            sum += val;
        }

        sum = sum / 2;

        int[][] dp = new int[A.length + 1][sum + 1];

        /**
         *   With no element the value will be infinite
         *   Note: Try to avoid Integer.MAX_VALUE
         */
        Arrays.fill(dp[0], 9999999);

        /**
         *   Intention is to find the Minimum element to form the sum as (Total sum / 2)
         *
         *   Meaning Each cell of DP Array: For the current sum [col] and till current elements [row] what is the Minimum elements needed.
         *   Simple Knap Sack Logic
         */
        for(int i = 1 ; i < dp.length ; i++){
            int currentVal = A[i - 1];
            for(int j = 1 ; j < dp[i].length ; j++){
                if(j < currentVal){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j] , 1 + dp[i - 1][j - currentVal]);
                }
            }
        }


        // for(int[] arr : dp){
        //     System.out.println(Arrays.toString(arr));
        // }


        // If the total sum can't be make into half equal sum then look for the sum which can be made using all the values
        // by moving twards the left from the bottom right corner
        while (dp[A.length][sum] == 9999999) {
            sum--;
        }

        return dp[A.length][sum];
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        // find the sum of all elements of array
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        sum = sum / 2;
        // we will store
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 0; i < A.size() + 1; i++) {
            List<List<Integer>> arr = new ArrayList<>();
            List<Integer> pr = new ArrayList();
            pr.add(0);
            pr.add(0);
            for (int j = 0; j < sum + 1; j++) {
                arr.add(j, pr);
            }
            dp.add(i, arr);
        }

        for (int i = 1; i < A.size() + 1; i++) {
            int currentVal = A.get(i - 1);
            List<List<Integer>> medValue = dp.get(i);
            for (int j = 1; j < sum + 1; j++) {
                if (currentVal > j) {
                    // dont consider it
                    List<Integer> value = dp.get(i - 1).get(j);
                    medValue.set(j, value);
                } else {
                    // we have two cases either consider element or not
                    int includeSum = currentVal + dp.get(i - 1).get(j - currentVal).get(0);
                    int includeFlip = 1 + dp.get(i - 1).get(j - currentVal).get(1);

                    int excludeSum = dp.get(i - 1).get(j).get(0);
                    int excludeFlip = dp.get(i - 1).get(j).get(1);

                    List<Integer> ans = compare(includeSum, includeFlip, excludeSum, excludeFlip);
                    medValue.set(j, ans);
                }
            }
            dp.set(i, medValue);
        }
        return dp.get(A.size()).get(sum).get(1);
    }

    private List<Integer> compare(int includeSum, int includeFlip, int excludeSum, int excludeFlip) {
        List<Integer> asn = new ArrayList<>();
        if (includeSum > excludeSum) {
            asn.add(includeSum);
            asn.add(includeFlip);
        } else if (includeSum < excludeSum) {
            asn.add(excludeSum);
            asn.add(excludeFlip);
        } else {
            if (includeFlip < excludeFlip) {
                asn.add(includeSum);
                asn.add(includeFlip);
            } else {
                asn.add(excludeSum);
                asn.add(excludeFlip);
            }
        }
        return asn;
    }

    private int find(int[] input, int[][] dp, int index, int mode) {
        // sanity check
        if (index < 0 || index > input.length)
            return -1;

        // dp check
        if (dp[mode][index] != -1)
            return dp[mode][index];
        // base case
        if (index == 0) {
            if (mode == 0)
                dp[mode][index] = -1 * input[index];
            else
                dp[mode][index] = input[index];
            return dp[mode][index];
        }

        // recurrence relationship
        int ans1 = find(input, dp, index - 1, mode) + input[index];
        int ans2 = find(input, dp, index - 1, mode) + -1 * input[index];
        if (ans1 >= 0 && ans2 >= 0)
            dp[mode][index] = Math.min(ans1, ans2);
        else if (ans1 < 0 && ans2 < 0)
            dp[mode][index] = Math.max(ans1, ans2);
        else if (ans1 < 0)
            dp[mode][index] = ans2;
        else
            dp[mode][index] = ans1;
        return dp[mode][index];

    }
}
