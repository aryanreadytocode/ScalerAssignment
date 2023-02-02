package Intermediate.Arrays.IntroToArray.asg;

import java.util.HashMap;

/**
 * Check if there exist a pair (i, j) such that A[i] + A[j] = K
 * Note (i != j)*/
public class PairSum {

    public static void main(String[] args) {
        int[] input = {3, -2, 1, 4, 3, 6, 8};
        int sum = 17;
        boolean ans = new PairSum().find(input, sum);
        System.out.println(ans);
    }

    private boolean find(int[] input, int sum) {
        HashMap<Integer, Void> hashMap = new HashMap<>();
        for (int i: input) {
            int j = sum - i;
            if (hashMap.containsKey(j))
                return true;
            hashMap.put(i, null);
        }
        return false;
    }
}
