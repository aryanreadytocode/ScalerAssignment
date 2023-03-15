package advance.dp_4.hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] A = {1, 3, 7, 11, 12, 14, 18};
        int ans = new LengthOfLongestFibonacciSubsequence().solve(A);
        System.out.println(ans);
    }

    private int solve(int[] A) {
        int N = A.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i<N; i++) {
            index.put(A[i], i);
        }
        int[][] dp = new int[N][N];
        for (int[] arr: dp)
            Arrays.fill(arr, 0);
        int ans = 0;
        for (int k = 0; k<N; k++) {
            for (int j = 0; j<k; j++) {
                if (A[k]-A[j] < A[j] && index.get(A[k] - A[j]) != null) {
                    int i = index.get(A[k]- A[j]);
                    dp[j][k] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[j][k] +2 );
                }
            }
        }
        return ans>=3?ans:0;
    }

    private int solve1(int[] A) {
        int length = 0;
        for (int i = 0; i<A.length-1; i++) {
            int lengthM = 2;
            int i1 = A[i];
            int i2 = A[i+1];
            for (int j = i+2; j < A.length; j++) {
                if (A[j] == i1 + i2) {
                    lengthM++;
                    i1 = i2;
                    i2 = A[j];
                }
            }
            length = Math.max(length, lengthM);
        }
        return length;
    }
}
