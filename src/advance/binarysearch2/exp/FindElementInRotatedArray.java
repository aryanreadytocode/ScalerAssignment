package advance.binarysearch2.exp;

public class FindElementInRotatedArray {
    public static void main(String[] args) {
        int[] rotatedArr = {20, 30, 50, 70, 90, 4, 5, 6, 7, 10};
        int index = find(rotatedArr, 5, 6);
        System.out.println("Index :"+index);
    }

    public static int find(int[] A, int rotation, int valueToFind) {
        if (valueToFind>=A[0]) {
            int end = rotation-1;
            int start = 0;
            while (start<=end) {
                int mid = start + (end - start) /2;
                if (valueToFind< A[mid]){
                    end = mid-1;
                }else if (valueToFind > A[mid]){
                    start = mid+1;
                }else {
                    return mid;
                }
            }
        }else {
            int end = A.length-1;
            int start = rotation+1;
            while (start<=end) {
                int mid = start + (end - start) /2;
                if (valueToFind< A[mid]){
                    end = mid-1;
                }else if (valueToFind > A[mid]){
                    start = mid+1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
