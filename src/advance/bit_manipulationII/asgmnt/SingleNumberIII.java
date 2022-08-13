package advance.bit_manipulationII.asgmnt;

public class SingleNumberIII {

    public static void main(String[] args) {
        int[] arr = new int[] {10, 8, 8, 9, 12, 9, 6, 11, 10, 6, 12, 17};
        System.out.println(solve(arr).toString());
    }

    public static int[] solve(int[] A) {
        int ele1 = 0;
        int ele2 = 0;
        int xor = A[0];
        int size = A.length;
        for (int i = 1; i<size; i++) {
            xor ^= A[i];
        }
        int bitPosition = 0;
        for (int j = 0; j<32; j++) {
            if(((xor>>j) & 1) == 1){
                bitPosition = j;
                break;
            }
        }
        for (int k = 0; k<size; k++) {
            if(((1<<bitPosition) & A[k]) >0) {
                ele1 ^= A[k];
            }else {
                ele2 ^= A[k];
            }
        }
        return new int[]{ele2, ele1};
    }
}
