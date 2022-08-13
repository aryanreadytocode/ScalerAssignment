package advance.sorting3.exp;

import java.util.Arrays;

/*
* Given two Arrays A[n] and B[n]. Calculate no of pairs i, j such that A[i]>A[j]
* Ex- A = [7, 0, 5], B = [2, 0, 6] no of pairs = (7, 2), (7, 0), (7, 6), (3, 2), (3, 0), (5, 2), (5, 0) = 7 pairs
* */
public class PairOfInterest {

    public static void main(String[] args) {
        int[] A = {7, 0, 5};
        int[] B = {2, 0, 6};
        System.out.println(noOfPairs(A, B));
    }

    public static int noOfPairs(int[] A, int[] B) {
        int count = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int countA = 0;
        int countB = 0;
        while (countA<A.length && countB<B.length) {
            if (A[countA] > B[countB]) {
                count += A.length - countA;
                countB++;
            } else  {
                countA++;
            }
        }
        return count;
    }
}
