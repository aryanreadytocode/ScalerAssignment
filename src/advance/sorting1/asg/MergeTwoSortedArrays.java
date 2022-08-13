package advance.sorting1.asg;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] A = { 1, 2  };
        int[] B = { -1, 2};
        System.out.println(Arrays.toString(solve(A, B)));
    }

    public static int[] solve(final int[] A, final int[] B) {
        int countA = 0;
        int countB = 0;
        int[] res = new int[A.length+B.length];
        for(int i = 0; i<res.length; i++) {
            if(countA == A.length) {
                res[i] = B[countB];
                countB++;
            }else if(countB == B.length) {
                res[i] = A[countA];
                countA++;
            }else if(A[countA]<=B[countB]){
                res[i] = A[countA];
                countA++;
            }else if(A[countA]>=B[countB]){
                res[i] = B[countB];
                countB++;
            }
        }
        return res;
    }
}
