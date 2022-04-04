package recursion2;
/*
* Problem Description
Given a number A, we need to find the sum of its digits using recursion.



Problem Constraints
1 <= A <= 109



Input Format
The first and only argument is an integer A.



Output Format
Return an integer denoting the sum of digits of the number A.



Example Input
Input 1:

 A = 46
Input 2:

 A = 11
* */
public class SumOfDigits {
    public int solve(int A) {
        if (A ==0)
            return 0;

        return A%10 + solve(A/10);
    }
}
