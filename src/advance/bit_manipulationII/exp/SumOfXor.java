package advance.bit_manipulationII.exp;

import advance.bit_manipulation.exp.CheckBit;

/*
* Given N positive integers, calculate sum of xor of all pairs.
* */
public class SumOfXor {

    public static void main(String[] args) {
        System.out.println(xorSum(new int[]{3, 1, 5}));
    }

    public static int xorSum(int[] A) {
        int size = A.length;
        int xorSum = 0;
        for (int i = 0; i<32; i++) {
            int setBits = 0;
            for (int j = 0; j<size; j++) {
                if (CheckBit.checkBit(A[j], i))
                    setBits++;
            }
            xorSum += 2 * setBits * (size-setBits) * (1<<i);
        }
        return xorSum;
    }
}
