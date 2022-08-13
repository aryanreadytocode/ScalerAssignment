package advance.bit_manipulation.exp;
/*
* Given N elements, every elements repeats twice except 2 unique elements, find the two unique elements
* */
public class TwoUniqueElements {
    public static void main(String[] args) {
        int[] A = {10, 8, 8, 9, 12, 9, 6, 11, 10, 6, 12, 17};
        twoUniqueElements(A);
    }

    public static void twoUniqueElements(int[] N) {
        int ele1 = 0;
        int ele2 = 0;
        int xorVal = N[0];
        for(int i = 1; i<N.length; i++) {
            xorVal ^= N[i];
        }
        int positionToPartition = 0;
        for (int i = 0; i<32; i++) {
            if (CheckBit.checkBit(xorVal, i)){
                positionToPartition = i;
                break;
            }
        }

        for (int ele: N) {
            if (CheckBit.checkBit(ele, positionToPartition))
                ele1 ^= ele;
            else
                ele2 ^= ele;
        }
        System.out.println("Ele: "+ele1+" Ele2: "+ele2);
    }
}
