package advance.sorting1.exp;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {3, -1, 6, 9, 4, 2, 5, 4};
        try {
            System.out.println(Arrays.toString(sort(A, 0, A.length-1)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int[] sort(int[] A, int start, int end) throws IllegalAccessException {
        if (start>end)
            throw new IllegalAccessException("Illegal Arguments");
        if (start == end)
            return new int[]{A[start]};

        int mid = (start+end)/2;
        int[] half1 = sort(A, start, mid);
        int[] half2 = sort(A, mid+1, end);

        return merge(half1, half2);


    }
     public static int[] merge(int[] A, int[] B) {
        int countA = 0;
        int countB = 0;
        int totalLength = A.length+B.length;
        int[] res = new int[totalLength];
        for (int i= 0 ; i<totalLength; i++) {
            if(countA == A.length) {
                res[i] = B[countB];
                countB++;
            }else if(countB == B.length) {
                res[i] = A[countA];
                countA++;
            }else if (A[countA] < B[countB]) {
                res[i] = A[countA];
                countA++;
            }else if (A[countA] > B[countB]) {
                res[i] = B[countB];
                countB++;
            }

        }
        return res;
     }
}
