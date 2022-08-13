package Intermediate.modular_arithmetics;
/*
* Problem Description
You are given two non-negative integers, A and B. Find the value of the Least Common Multiple (LCM) of A and B.

LCM of two integers is the smallest positive integer divisible by both.



Problem Constraints
1 <= A, B <= 1000



Input Format
The first argument is an integer A.

The second argument is an integer B.



Output Format
Return an integer.



Example Input
Input 1:

 A = 2
 B = 3
Input 2:

 A = 9
 B = 6
Input 3:

 A = 2
 B = 6


Example Output
Output 1:

 6
Input 2:

 18
Input 3:

 6


Example Explanation
Explanation 1:

 6 is the smallest positive integer which is divisible by both 2 (2 * 3 = 6) and 3 (3 * 2 = 6).
Explanation 2:

 18 is the smallest positive integer which is divisible by both 9 (9 * 2 = 18) and 6 (6 * 3 = 18).
Explanation 3:

 6 is the smallest positive integer which is divisible by both 2 (2 * 3 = 6) and 6 (6 * 1 = 6).
* */
public class LeastCommonMultiple {

    public int LCM(int A, int B) {
        int min = 0, max = 0;
        if(A == B)
            return A;
        min = (Math.min(A, B));
        max = (min == A ? B : A);
        //int lcm = 0;
        for(int i = 2; i < max; i++){
            int mul = min * i;
            if(mul%max == 0)
                return mul;
        }
        return A*B;
    }
}
