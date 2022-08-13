package advance.sorting2.exp;

import java.util.Arrays;

/*Sort based on no of factors*/
public class SortFactosrs {

    public static void main(String[] args) {
        int[] A = {2,6,8,8};
        System.out.println(Arrays.toString(mergeSorts(A, 0, A.length - 1)));
    }

    private static int[] mergeSorts(int[] A, int start, int end) {
        if (start == end)
            return new int[]{A[start]};

        int middle = (start+end)/2;
        int[] left = mergeSorts(A, start, middle);
        int[] right = mergeSorts(A, middle+1, end);
        return merges(left, right);
    }

    private static int[] merges(int[] A, int[] B) {
        int countA = 0;
        int countB = 0;
        int[] res = new int[A.length+B.length];
        for (int i = 0; i < res.length; i++) {
            if (countA == A.length) {
                res[i] = B[countB];
                countB++;
            } else if (countB == B.length) {
                res[i] = A[countA];
                countA++;
            }else if (compareFun(A[countA], B[countB])) {
                res[i] = A[countA];
                countA++;
            }else {
                res[i] = B[countB];
                countB++;
            }
        }
        return res;
    }

    private static boolean compareFun(int A, int B) {
        int Fa = noOfFactors(A);
        int Fb = noOfFactors(B);
        if (Fa<Fb)
            return  true;
        else if(Fb<Fa)
            return false;
        else {
            return A > B;
        }
    }

    private static int noOfFactors(int n) {
        int fact = 0;
        for (int i = 1; i*i <= n; i++) {
            if (i*i == n)
                fact++;
            else
                fact = fact+2;
        }
        return fact;
    }
}
