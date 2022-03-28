package striing;
/*
* Problem Description

Find number of occurrences of bob in the string A consisting of lowercase english alphabets.



Problem Constraints

1 <= |A| <= 1000


Input Format

The first and only argument contains the string A consisting of lowercase english alphabets.


Output Format

Return an integer containing the answer.


Example Input

Input 1:

  "abobc"
Input 2:

  "bobob"


Example Output

Output 1:

  1
Output 2:

  2


Example Explanation

Explanation 1:

  The only occurrence is at second position.
Explanation 2:

  Bob occures at first and third position.
* */
public class CountOccurrences {

    public int solve(String A) {
        int n = A.length();
        int res = 0;
        for (int i = 1; i<n-1; i++) {
            if(A.charAt(i-1)=='b' && A.charAt(i)=='o' && A.charAt(i+1)=='b') {
                res++;
            }
        }
        return res;
    }
}
