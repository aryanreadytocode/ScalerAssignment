package advance.bit_manipulation.exp;
/*
* Every elements repeats thrice, except 1 unique element.
* */
public class UniqueElementsII {

    public static void main(String[] args) {
        int[] A = {5, 7, 5, 4, 7, 11, 11, 0, 11, 7, 5, 4, 4};
        System.out.println(findUniqueElements(A));
    }

    public static int findUniqueElements(int[] A) {
        int value = 0;
        for (int i = 0; i<32; i++) {
            int count = 0;
            for (int k : A) {
                if (CheckBit.checkBit(k, i))
                    count++;
            }
            value += (count%3)*(1<<i);
        }
        return value;
    }
}
