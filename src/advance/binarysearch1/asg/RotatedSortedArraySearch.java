package advance.binarysearch1.asg;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
//        int[] A = {4, 5, 0, 1, 2, 3};
//        int[] A = {1, 7, 67, 133, 178};
        int[] A = {5,1,3};
        int index = search(A, 5);
        System.out.println("Index: "+index);
    }

    public static int search(final int[] A, int B) {
        int start = 0;
        int end = A.length-1;
        // first find the value of rotation
        int rotationValue = 0;
        int mid;
        while(start < end){
            mid = start + (end - start)/2;
            if(A[mid]> A[mid+1]) {
                rotationValue = mid + 1;
                break;
            }else if (A[mid] < A[mid-1]) {
                rotationValue = mid;
                break;
            }else if (A[0] > A[mid])
                end = mid-1;
            else if(A[0] < A[mid]) {
                start = mid+1;
            }
        }
        start = 0;
        end = A.length-1;
        if (B >= A[0] && rotationValue!= 0){
            end = rotationValue-1;
        }else if (B < A[0] && rotationValue != 0){
            start = rotationValue;
            end = A.length-1;
        }
        while(start<=end) {
            mid = start + (end - start)/2;
            if (A[mid] > B)
                end = mid - 1;
            else if(A[mid] < B)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
