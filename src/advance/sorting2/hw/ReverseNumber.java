package advance.sorting2.hw;

import java.util.ArrayList;

public class ReverseNumber {

    public static void main(String[] args) {
//        int[] A = {14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549, 57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611};
        int[] A = {1, 3, 2, 3, 1};
        System.out.println(new ReverseNumber().solve(A));
    }

    int count = 0;

    public int solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return count;
    }

    public int mergeSort(int[] A, int start, int end) {
        if (start == end)
            return 0;
        int middle = (start + end) / 2;
        int left = mergeSort(A, start, middle);
        int right = mergeSort(A, middle + 1, end);
        int merge = merge(A, start, middle, end);
        return left + right + merge;
    }

    public int merge(int[] A, int start, int middle, int end) { //13231
        int countA = start;
        int countB = middle + 1;
        int[] res = new int[end - start + 1];
        for (int i = 0; i < res.length; i++) {
            if (countA == middle + 1) {
                res[i] = A[countB];
                countB++;
            } else if (countB == end + 1) {
                res[i] = A[countA];
                countA++;
            } else if (A[countA] <= A[countB]) {
                res[i] = A[countA];
                countA++;
            } else if (A[countA] > A[countB]) {
                if (A[countA] > 2 * (A[countB])) {
                    count += middle - start + 1;

                }
                res[i] = A[countB];
                countB++;
            }
        }

        for (int j = 0; j < res.length; j++) {
            A[start+j] = res[j];
        }
        return count;
    }


    }
