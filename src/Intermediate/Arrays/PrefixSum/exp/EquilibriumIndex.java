package Intermediate.Arrays.PrefixSum.exp;
/**
 * Given an array of size N, count no of equilibrium index
 * An index is said to be equilibrium index of
 * sum of all ele just before index = sum of all ele just after given index*/
public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        solveNaive(A);
//        solvePFApproach(A);
    }

    private static void solvePFApproach(int[] input) {
        // prepare prefix sum array
        int[] pf = new int[input.length];
        pf[0] = input[0];
        for (int i = 1; i< input.length; i++) {
            pf[i] = pf[i-1] + input[i];
        }
        // find equilibrium
        for (int i = 0; i< input.length; i++) {
            int ls = 0;
            int rs = 0;
            if (i != 0) {
                ls = pf[i-1];
            }
            if (i!=input.length-1) {
                rs = pf[input.length-1] - pf[i];
            }
            if (ls == rs)
                System.out.println(i);
        }
    }

    private static void solveNaive(int[] input) {
        for (int i = 0; i< input.length; i++) {
            int ls = 0;
            if (i > 0) {
                for (int j = 0; (j < i); j++) {
                    ls += input[j];
                }
            }
            int rs = 0;
            if (i < input.length-1) {
                for (int k = input.length - 1; (k > i); k--) {
                    rs += input[k];
                }
            }
            if (ls == rs)
                System.out.println(i);
        }
    }
}
