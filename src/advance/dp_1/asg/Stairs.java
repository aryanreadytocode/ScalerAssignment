package advance.dp_1.asg;

import java.util.Arrays;

public class Stairs {

    public static void main(String[] args) {
        int stairsNo = 46312;
//        int stairsNo = 5;
        int ans = climbStairs(stairsNo);
        System.out.println("No of unique step to "+stairsNo+" : "+ans);
    }

    private static int climbStairs(int A) {
        int mod = 1000000007;
        int[] memoizedArray = new int[A+1];
        Arrays.fill(memoizedArray, -1);
        return solve1(A, memoizedArray, mod);
    }

    private static int solve(int A, int[] memoizedArray, int mod) {
        // base case
        if (A < 0)
            return 0;
        // check if answer is already computed
        if (memoizedArray[A] != -1)
            return memoizedArray[A];

        // check for base case
        // if no stairs are 1 or 0 there could be only one unique path to then
        if (A == 0 || A==1) {
            memoizedArray[A] = 1;
            return 1;
        }

        // recurrence relationship
        int ans = (solve(A-1, memoizedArray, mod)%mod +solve(A-2, memoizedArray, mod)%mod)%mod;
        memoizedArray[A] = ans;
        ans = ans%mod;
        System.out.println(ans);
        return ans;
    }

    private static int solve1(int A, int[] memoizedArray, int mod) {

        int zeroStep = 1;
        int oneStep = 1;

        for (int i = 2; i<=A; i++) {
            int temp = (zeroStep%mod+oneStep%mod)%mod;
            zeroStep = oneStep;
            oneStep = temp;
        }
        return oneStep;

    }



    }
