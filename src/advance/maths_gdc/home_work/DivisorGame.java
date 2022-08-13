package advance.maths_gdc.home_work;

/*
* Problem Description
Scooby has 3 three integers A, B, and C.

Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.



Problem Constraints
1 <= A, B, C <= 109



Input Format
First argument is a positive integer A
Second argument is a positive integer B
Third argument is a positive integer C



Output Format
One integer corresponding to the number of special integers less than or equal to A.



Example Input
Input 1:

 A = 12
 B = 3
 C = 2
Input 2:

 A = 6
 B = 1
 C = 4


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
Explanation 2:

 Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
* */
public class DivisorGame {

    public static void main(String[] args) {
        int A = 745234167;
        int B = 4110;
        int C = 4630;
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int B, int C) {

        if(B==C)
            return A/B;
        else if (Math.max(B,C)%Math.min(B,C)==0){
            return A/Math.max(B,C);
        }else {
            int gcd = findGcd(B, C);
            int divideBy = B*C/gcd;
            return A /divideBy;
        }

        /*int count1 = 1;
        for (int i = gcd; i<=A; i = count1*gcd) {
            if(i%C ==0 && i%B==0)
                count++;
            count1++;
        }*/
    }

    public static int findGcd(int A1, int A2) {
        if(A1==0 || A2==0)
            return Math.max(A1, A2);
        return findGcd(A2%A1, A1);
    }

}
