package advance.bit_manipulationII.exp;

import advance.bit_manipulation.exp.CheckBit;

import java.util.Arrays;

/*
* Given N Array elements, choose 2 indices (i, j) such that (i != j) and (A[i] & A[j]) is max.
* */
public class MaxBitwise {

    public static void main(String[] args) {
        System.out.println(maxBitwise(new int[]{26, 13, 23, 28, 27, 7, 25}));
    }

    public static int maxBitwise(int[] A) {
        int size = A.length;
        int maxAnd = 0;
        for (int i = 4; i>=0; i--) {
            int setBits = 0;
            for(int j = 0; j<size; j++) {
                if (CheckBit.checkBit(A[j], i))
                    setBits++;
            }
            if (setBits>=2){ //Asked in google find four pairs whose and bitwise is max. simple we need to make it setBits>=4
                maxAnd += 1<<i;
                for (int k = 0; k<size; k++) {
                    if (!CheckBit.checkBit(A[k], i))
                        A[k] = 0;
                }
            }
        }
        return maxAnd;
    }
}
