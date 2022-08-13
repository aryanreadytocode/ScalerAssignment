package advance.bit_manipulationII.asgmnt;

public class SingleNumberII {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1}));
    }

    public static int singleNumber(final int[] A) {
        int uniqueElement = 0;
        int size = A.length;
        for (int i = 0; i<32; i++) {
            int setBits = 0;
            for (int j = 0; j<size; j++) {
                if(((A[j]>>i) & 1) == 1){
                    setBits++;
                }
            }
            uniqueElement += (setBits%3)*(1<<i);
        }
        return uniqueElement;
    }
}
