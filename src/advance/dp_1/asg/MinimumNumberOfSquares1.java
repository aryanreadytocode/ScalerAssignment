package advance.dp_1.asg;

import java.util.Arrays;

public class MinimumNumberOfSquares1 {
    static int[] mA;
    public static void main(String[] args) {
        int A = 1987;
        int ans = countMinSquares(A);
        System.out.println(ans);
    }
    public static int countMinSquares(int A) {
        mA = new int[A + 1];
        Arrays.fill(mA, -1);
        return solve(A);
    }

    private static int solve(int input) {
        // sanity check
        if (input < 0)
            return -1;
        // check if problem is already computed or not
        if (mA[input] != -1)
            return mA[input];

        // check for base condition
        // for every perfect square number there is exact on square root sum
        // for example 4 >> 2^2 >1; 9 >> 3^2 > 1
        // and for 0 there is one square root sum
        if (input == 0) {
            mA[input] = 0;
            return 0;
        }
        if (isPerfectSquareRoot(input)){
            mA[input] = 1;
            return 1;
        }


        // recurrence relationship
        // find floor of maximum square root of input
        int x = (int) Math.sqrt(input);
        int mini = Integer.MAX_VALUE;
        for (int k = 1; k <= x; k++) {
            mini = Math.min(mini, 1+ solve(input-(k*k)));
        }
        mA[input] = mini;
        return mini;

    }

    private static boolean isPerfectSquareRoot(int input) {
        return Math.ceil((double) Math.sqrt(input)) ==
                Math.floor((double) Math.sqrt(input));
    }
}
