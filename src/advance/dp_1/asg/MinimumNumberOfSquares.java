package advance.dp_1.asg;

import java.util.Arrays;

public class MinimumNumberOfSquares {

    public static void main(String[] args) {
        int A = 19;
        int ans = countMinSquares(A);
        System.out.println(ans);
    }

    public static int countMinSquares(int A) {
        int[] mA = new int[A + 1];
        Arrays.fill(mA, -1);
        return solve(mA, A);
    }

    private static int solve(int[] mA, int input) {
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
        if (isPerfectSquareRoot(input)) {
            mA[input] = 1;
            return 1;
        }

        // recurrence relationship
        int a = (int) Math.sqrt(input);
        int ans1 = solve(mA, a*a);
        int ans2 = solve(mA, input-a*a);
        mA[input] = ans1+ans2;
        return mA[input];
    }

    private static boolean isPerfectSquareRoot(int input) {
        return Math.ceil((double) Math.sqrt(input)) ==
                Math.floor((double) Math.sqrt(input));
    }
}
