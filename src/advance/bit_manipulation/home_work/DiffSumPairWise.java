package advance.bit_manipulation.home_work;

import advance.bit_manipulation.exp.CheckBit;

public class DiffSumPairWise {

    public static void main(String[] args) {
        System.out.println(cntBits(new int[]{1,3,5}));
    }

    public static int cntBits(int[] A) {
        int size = A.length;
        int mod_val = (int) (1e9+7);
        int totalNoOfDiffBits = 0;
        for (int i = 0; i<32; i++) {
            long setBits=0;
            for(int j = 0; j<size; j++) {
                if(CheckBit.checkBit(A[j], i))
                    setBits++;
            }
            totalNoOfDiffBits += ((setBits%mod_val)*((size-setBits)%mod_val)%mod_val);
        }
        return 2*totalNoOfDiffBits;
    }
}
