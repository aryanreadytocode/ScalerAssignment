package advance.sorting2.asg;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] A = { 0, 0, 0, 0, 0 };
//        int[] A = {3, 30, 34, 5, 9 };
        System.out.println(new Solution().largestNumber(A));
    }

    public String largestNumber(final int[] A) {
        int[] ans = new Solution().mergeSort(A, 0, A.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0)
                sb.append(ans[i]);
        }
        if(sb.length() != 0)
            return sb.toString();
        else
            return "0";
    }

    public int[] mergeSort(int[] A, int start, int end) {
        if (start == end)
            return new int[] {A[start]};

        int middle = (start+end)/2;
        int[] left = new Solution().mergeSort(A, start, middle);
        int[] right = new Solution().mergeSort(A, middle+1, end);
        return merge(left, right);
    }

    public int[] merge(int[] A, int[] B) {
        int countA = 0;
        int countB = 0;
        int[] res = new int[A.length+B.length];
        for (int i = 0; i < res.length; i++) {
            if (countA == A.length) {
                res[i] = B[countB];
                countB++;
            }else if (countB == B.length) {
                res[i] = A[countA];
                countA++;
            } else if (new Solution().compare(A[countA], B[countB])) {
                res[i] = A[countA];
                countA++;
            } else {
                res[i] = B[countB];
                countB++;
            }
        }
        return res;
    }

    public boolean compare(int A, int B) {
        String AB = (A+""+B);
        String BA = (B+""+A);
        return AB.compareTo(BA) >= 0;
    }
}
