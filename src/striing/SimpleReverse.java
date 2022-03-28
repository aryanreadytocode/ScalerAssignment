package striing;
/*
* Problem Description

Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints

1 <= |A| <= 105

String A consist only of lowercase characters.



Input Format

First and only argument is a string A.



Output Format

Return a string denoting the reversed string.



Example Input

Input 1:

 A = "scaler"
Input 2:

 A = "academy"


Example Output

Output 1:

 "relacs"
Output 2:

 "ymedaca"


Example Explanation

Explanation 1:

 Reverse the given string.
* */
public class SimpleReverse {

    public String solve(String A) {
        StringBuilder s = new StringBuilder(A);
        int l = 0;
        int r = A.length()-1;
        while (l < r) {
            char temp = s.charAt(l);
            s.setCharAt(l, s.charAt(r));
            s.setCharAt(r, temp);
            l++;
            r--;
        }
        return s.toString();
    }

}
