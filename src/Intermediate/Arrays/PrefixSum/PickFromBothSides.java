package Intermediate.Arrays.PrefixSum;

import java.util.ArrayList;

/*Problem Description

Given an integer array A of size N.

You can pick B elements from either left or right end of the array A to get maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . you need to return the maximum possible sum of elements you can pick.


Problem Constraints

1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format

First argument is an integer array A.

Second argument is an integer B.



Output Format

Return an integer denoting the maximum possible sum of elements you picked.



Example Input

Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [1, 2]
 B = 1


Example Output

Output 1:

 8
Output 2:

 2


Example Explanation

Explanation 1:

 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Pick element 2 from end as this is the maximum we can get
 */
public class PickFromBothSides {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(6);
        al.add(2);
        al.add(1);
        al.add(5);
        al.add(6);
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(new PickFromBothSides().solve1(al, 8));
    }

    public int solve(ArrayList<Integer> A, int B) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int currentSum = 0;
            for (int j = i; j < i + B; j++) {
                int index = j;
                if (j >= A.size())
                    index = j % A.size();
                currentSum += A.get(index);
            }
            if (sum < currentSum)
                sum = currentSum;
        }
        return sum;
    }

    /*
    A : [ -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509,
    -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229,
    538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547,
    644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35 ]
    B : 48
    */

    public int solve1(ArrayList<Integer> A, int B) {
        // get the prefix sum of given array
        ArrayList<Integer> al = new ArrayList<>(A.size());
        al.add(0, A.get(0));
        for (int i = 1; i < A.size(); i++) {
            int value = al.get(i - 1) + A.get(i);
            al.add(i, value);
        }

        // now find the sum
        int start;
        int end;
        int maxSum = Integer.MIN_VALUE;
        for (int i = A.size()-B; i<=A.size(); i++) {
            int currentSum;
            start = i;
            if (i == 0){
                end = B -1;
                currentSum = al.get(end);
            } else if (start > A.size() - B) {
                end = (start + B - 1) % A.size();
                currentSum = al.get(A.size() - 1) - al.get(start - 1) + al.get(end);
            } else {
                end = start + B - 1;
                currentSum = al.get(end) - al.get(start - 1);
            }

            if (currentSum > maxSum)
                maxSum = currentSum;
        }
        return maxSum;
    }


}
