package bit_manipulation1;
/*
* Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints

0 <= A <= 232



Input Format

First and only argument of input contains an integer A.



Output Format

Return a single unsigned integer denoting the decimal value of reversed bits.
* */
public class ReverseBits {
    public static void main(String[] args) {
        new ReverseBits().reverse(3);
    }

    public long reverse(long a) {
        //change to binary
        StringBuilder sb = new StringBuilder();
        while(a>0){
            long rem = a%2;
            a /= 2;
            sb.append(rem);
        }
        int length = sb.length();
        for(int i = 0; i<32-length; i++){
            sb.append(0);
        }
        long res = 0;

        for(int i = 0; i<sb.length(); i++){
            double power = Math.pow(2,  i);
            double value = Character.getNumericValue(sb.charAt(sb.length()-1-i));
            if (value==0)
                continue;
            res += power*value;
        }
        return res;
    }
}
