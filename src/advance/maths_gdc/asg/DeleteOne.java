package advance.maths_gdc.asg;

/*
*Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.



Problem Constraints

2 <= N <= 105
1 <= A[i] <= 109



Input Format

First argument is an integer array A.



Output Format

Return an integer denoting the maximum value of GCD.



Example Input

Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output

Output 1:

 6
Output 2:

 15


Example Explanation

Explanation 1:


 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum vallue of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
* */
public class DeleteOne {

    public static void main(String[] args) {
        int[] A = {21, 7, 3, 42, 63};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int gcd1 = Integer.MAX_VALUE;
        int N = A.length;
        int gcd = 0;
        int index = -1;
        for(int i = 0; i<N; i++){
            gcd = findGcd(gcd, A[i]);
            if (gcd < gcd1) {
                gcd1 = gcd;
                index = i;
            }
        }
        int gcdf = 0;
        for (int j= 0; j<N; j++){
            if(index != j)
                gcdf = findGcd(gcdf, A[j]);
        }
        return gcdf;
    }

    public static int findGcd(int a, int b){
        if(a == 0 || b==0)
            return Math.max(a, b);
        return findGcd(b%a, a);
    }
}
