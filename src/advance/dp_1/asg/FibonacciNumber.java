package advance.dp_1.asg;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
//        int A = 3;
        int[] mA = new int[A+1];
        Arrays.fill(mA, -1);
        int ans = solve(A, mA);
        System.out.print(ans);
    }

    private static int solve(int A, int[] mA) {
        // sanity check
        if(A <0)
            return 0;
        //check if already computed
        if(mA[A] != -1)
            return mA[A];

        //base condition
        if(A == 0 || A==1) {
            mA[A] = A;
            return A;
        }

        // recurence relation ship
        int ans = solve(A-1, mA) + solve(A-2, mA);
        mA[A] = ans;
        return ans;
    }
}
