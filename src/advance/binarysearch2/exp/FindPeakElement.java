package advance.binarysearch2.exp;
/*
* Given N distinct numbers, return any peak element. An element is said to be peak if it is greater
* than it's adjacent element.
* A[i-1]<A[i]>A[i+1]
* */
public class FindPeakElement {
    public static void main(String[] args) {
//        int[] A = {7,8,9,10,1,5,4,2,60,50,55,70,69};
        int[] A = {10};
        int peakElement = peakElement(A);
        System.out.println("Peak Element :"+peakElement);
    }

    public static int peakElement(int[] A) {
        int start = 0;
        int end = A.length-1;
        if (A[0]>A[1])
            return A[0];
        else if (A[A.length-1]>A[A.length-2])
            return A[A.length-1];
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && mid + 1 <= A.length - 1) {
                if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1])
                    return A[mid];
                else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1])
                    end = mid - 1;
                else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
                    start = mid + 1;
                else if (A[mid - 1] > A[mid] && A[mid] < A[mid + 1]) {
                    // reject which ever part of array you want it totally your call
                    start = mid + 1;
//                end = mid-1;
                }
            }
        }
        return -1;
    }
}
