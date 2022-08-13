package advance.binarysearch1.asg;
/*
* Problem Description
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 106



Input Format
The first argument is an integer array A of size N.
The second argument is an integer B.



Output Format
Return an integer denoting the index of target value.



Example Input
Input 1:

A = [1, 3, 5, 6]
B = 5
Input 2:

A = [1]
B = 1


Example Output
Output 1:

2
Output 2:

0


Example Explanation
Explanation 1:

The target value is present at index 2.
Explanation 2:

The target value is present at index 0.
* */
public class SortedInsertPosition {

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6};
        int value = 1;
        int index = searchInsert(arr, value);
        System.out.println("Index of "+value + " "+index);
    }

    public static int searchInsert1(int[] A, int B) {
        int index = -1;
        for (int i = 0; i<A.length; i++) {
            if (A[i] == B)
                index = i;
            else if (i < A.length-1 && A[i] < B && A[i+1] > B)
                index = i+1;
            else if (i == A.length-1 && A[i] < B)
                return i+1;
        }
        return index;
    }
    public static int searchInsert(int[] A, int B) {
        int start = 0;
        int end = A.length-1;
        int index = 0;
        while (start <= end) {
            int mid = start + (end - start) /2;
            if (A[mid] > B) {
                index = mid;
                end = mid -1;
            }else if (A[mid] < B) {
                index = mid +1;
                start = mid+1;
            }else {
                index = mid;
            }

        }
        return index;
    }
}
