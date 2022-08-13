package Intermediate.arrays_math;

import java.util.ArrayList;
/*
* Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.



Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109


Input Format
The only argument is an integer array A.


Output Format
Return an integer.


Example Input
[1 2 3 1 1]


Example Output
1


Example Explanation
1 occurs 3 times which is more than 5/3 times.
* */
public class FindNthMagicNumber {
    public static void main(String[] args) {
        System.out.println(new FindNthMagicNumber().solve(10));
    }
    public int solve(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        int value = 1;
        while(res.size()<A){
            value = value*5;
            res.add(value);
            int sizeLoop = res.size()-1;
            for(int j=0; j<sizeLoop; j++){
                int sum = value + res.get(j);
                res.add(sum);
                if (res.size()==A)
                    break;
            }



        }
        return res.get(A-1);
    }
}
