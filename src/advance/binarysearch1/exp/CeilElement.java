package advance.binarysearch1.exp;

public class CeilElement {

    public static void main(String[] args) {
        int[] intArray = {-2,3,4,6,9,10,19,21};
        int noWhoseCielNeedToFind = 15;
        int ceilValue = ceil(intArray, noWhoseCielNeedToFind);
        System.out.println("Ceil Value:" +ceilValue);
    }

    private static int ceil(int[] intArray, int noWhoseCielNeedToFind) {
        int start = 0;
        int end = intArray.length;
        int ceilValue = intArray[intArray.length-1];
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (intArray[mid] == ceilValue) {
                return ceilValue;
            } else if (intArray[mid] > noWhoseCielNeedToFind) {
                ceilValue = Math.min(ceilValue, intArray[mid]);
                end = mid -1;
            } else
                start = mid +1;
        }
        return ceilValue;
    }
}
