package advance.backtrack_1.asg;

import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        int[] A = {1};
        int[][] ans = permute(A);
        for (int[] a: ans) {
            System.out.println(Arrays.toString(a));
        }
    }

    /*Example
     * InputArray = [1,2,3]
     * OutputAnswer = [
     *                   [1,2,3]
     *                   [1,3,2]
     *                   [2,1,3]
     *                   [2,3,1]
     *                   [3,1,2]
     *                   [2,2,1]
     *                       ]*/
    public static int[][] permute(int[] A) {
        int[][] res = new int[factorial(A.length)][];
        int index = 0;
        return permBack(A, res, index);
    }

    static int valueIndex = 0;
    public static int[][] permBack(int[] A, int[][] res, int index) {
        // sanity check
        if (index < 0 || index >= A.length) {
            return null;
        }
        // base case
        if (index == A.length - 1) {
            int[] a = A.clone();
            res[valueIndex] = a;
            valueIndex++;
            return res;
        }

        for (int j = index; j < A.length; j++) {
            swap(index, j, A);
            permBack(A, res, index+1);
            swap(index, j, A);
        }
        return res;
    }

    private static int[] swap(int index, int j, int[] A) {
        int temp = A[index];
        A[index] = A[j];
        A[j] = temp;
        return A;
    }

    private static int factorial(int n) {
        if (n<=0 | n == 1)
            return 1;

        return n * factorial(n-1);
    }

}
