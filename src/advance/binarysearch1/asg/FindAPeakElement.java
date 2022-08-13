package advance.binarysearch1.asg;

/*
* Problem Description
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
* */
public class FindAPeakElement {

    public static void main(String[] args) {
//        int[] A = {7,8,9,10,1,5,4,2,60,50,55,70,69};
        int[] A = {10};
        int peakElement = solve(A);
        System.out.println("Peak Element :" + peakElement);
    }

    public static int solve(int[] A) {

        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || A[mid] >= A[mid - 1] )&& (mid == A.length - 1 || A[mid] >= A[mid + 1])) {
                return A[mid];
            } else if (A[mid] <= A[mid+1]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

}
