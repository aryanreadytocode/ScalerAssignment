package advance.bit_manipulation.exp;
/*
* Given an array elements, array contains all elements from [1, N+2] except 2 elements, find two
* missing elements
* */
public class MissingElements {

    public static void main(String[] args) {
        int[] A = {3,6,1,4};
        missingElements(A);
    }

    public static void missingElements(int[] A) {
        int size = A.length;
        int missingEle1 = 0;
        int missingEle2 = 0;
        int xorOfAllElements = size+1^ size+2;
        int count = 1;

        for (int value : A) {
            xorOfAllElements ^= value^count;
            count++;
        }
        int positionOfSetBit = 0;
        for (int j = 0; j<32; j++) {
            if (CheckBit.checkBit(xorOfAllElements, j)) {
                positionOfSetBit = j;
                break;
            }
        }
        for (int k = 0; k<size+2; k++){
            if (CheckBit.checkBit(k+1, positionOfSetBit)) {
                missingEle1 ^= k+1;
            } else {
                missingEle2 ^= k+1;
            }
            if (k<size) {
                if (CheckBit.checkBit(A[k], positionOfSetBit)) {
                    missingEle1 ^= A[k];
                } else {
                    missingEle2 ^= A[k];
                }
            }
        }
        System.out.println("Missing Elements: "+missingEle1+", "+missingEle2);
    }
}
