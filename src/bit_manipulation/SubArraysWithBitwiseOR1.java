package bit_manipulation;

import java.util.ArrayList;
/*
* Problem Description
Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.


Problem Constraints
1 <= A <= 105


Input Format
The first argument is a single integer A.
The second argument is an integer array B.


Output Format
Return the number of subarrays with bitwise array 1.


Example Input
Input 1:
 A = 3
B = [1, 0, 1]
Input 2:
 A = 2
B = [1, 0]


Example Output
Output 1:
5
Output2:
2


Example Explanation
Explanation 1:
The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
Explanation 2:
The subarrays are :- [1], [0], [1, 0]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
* */
public class SubArraysWithBitwiseOR1 {

    public Long solve(int A, ArrayList<Integer> B) {
        long onesArrayCount = 0;
        long oneCount = 0;
        for(int i = 0; i<A; i++){
            if(B.get(i)==0)
                oneCount++;
            else if(B.get(i)==1 && oneCount !=0){
                onesArrayCount += (oneCount*(oneCount+1))/2;
                oneCount = 0;
            }
            if(i == (A-1) && oneCount!=0) {
                onesArrayCount += (oneCount*(oneCount+1))/2;
                oneCount = 0;
            }
        }
        long totalSubArr = ((long) A *(A+1)/2);
        return (totalSubArr - onesArrayCount);
    }
}
