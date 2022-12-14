package advance.dp_1.hw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaximumSumValue {
    int[][] dpArr;
    public static void main(String[] args) {
//        int[] input = {1, 5, -3, 4, -2};
        int[] input = {3, 2, 1};
//        int A = 2, B = 1, C = -1;
        int A = 1, B = -10, C = 3;
        int ans = new MaximumSumValue().solve(input, A, B, C);
        System.out.println(ans);
    }
    public int solve(int[] A, int B, int C, int D) {
        int N = A.length;
        int[][] dpArr = new int[N][3];
        dpArr[0][0] = A[0] * B;
        dpArr[1][0] = A[0]*C + dpArr[0][0];
        dpArr[2][0] = A[0]*D+dpArr[1][0];

        for (int i = 1; i<N; i++) {
            dpArr[0][i] = Math.max(A[i] * B, dpArr[0][i-1]);
            dpArr[1][i] = Math.max(dpArr[0][i]+C*A[i], dpArr[1][i-1]);
            dpArr[2][i] = Math.max(dpArr[1][i]+D*A[i], dpArr[2][i-1]);
        }
        return dpArr[N-1][2];
    }

}
