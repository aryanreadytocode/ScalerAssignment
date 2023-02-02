package Intermediate.Arrays.PrefixSum.exp;
/**
 * Given an array of N elements and Q queries. For each of the query
 * , print sum of element from index s to e
 * example:
 * A = {3,1,0,-2}
 * Queries
 * s = {1,2}
 * e = {2,3}
 * and sum[] = {sum A[s] to A[e]} = {1+0, 0+(-2)} = {1, -2}
 * * */
public class PrefixSum {

    public static void main(String[] args) {
        int[] A = {3,1,0,-2};
        int[] s = {0, 1};
        int[] e = {3, 2};
//        findSumPf(A, s, e);
        findSumNaive(A, s, e);
    }

    private static void findSumNaive(int[] a, int[] s, int[] e) {
        for (int i = 0; i<s.length; i++) {
            int sum = 0;
            for (int j = s[i]; j<=e[i]; j++) {
                sum += a[j];
            }
            System.out.println(sum);
        }
    }

    private static void findSumPf(int[] a, int[] s, int[] e) {
        // first find the prefix sum array
        int[] pf = new int[a.length];
        pf[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            pf[i] = pf[i-1] + a[i];
        }
        // iterate through the query to get sum
        // like to get sum from 2 to 4 index
        // we need to do like pf[e]-pf[s-1] if s>0
        // pf[e] if s==0

        for (int j = 0; j < s.length; j++) {
            if (s[j] == 0)
                System.out.println(pf[e[j]]);
            else
                System.out.println(pf[e[j]]-pf[s[j]-1]);
        }
    }
}
