package recursion2;

/*
* Problem Description
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).

Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.



Problem Constraints
-109 <= A <= 109
0 <= B <= 109
1 <= C <= 109


Input Format
Given three integers A, B, C.


Output Format
Return an integer.


Example Input
A = 2, B = 3, C = 3


Example Output
2


Example Explanation
23 % 3 = 8 % 3 = 2
* */
public class ImplementPowerFunction {

    public static void main(String[] args) {
        int A = 71045970;
        int B = 41535484;
        int C = 64735492;
        System.out.println(new ImplementPowerFunction().pow(A, B, C));
    }

    public int pow(int A, int B, int C) {
        long product;
        if(A==1)
            return 1;
        else if(A==0)
            return 0;
        else if(B == 0)
            return 1;

        long halfValue = pow(A, B/2, C);
        if(B%2 ==0) {
            product = ((halfValue%C)*(halfValue%C))%C;
        }else {
            product =  (((A%C) * (halfValue % C))%C * (halfValue % C)) % C;
            if(product<0)
                product += C;
        }
        return (int)(product);
    }
}
