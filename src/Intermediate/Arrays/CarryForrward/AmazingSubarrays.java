package Intermediate.Arrays.CarryForrward;

import java.util.Locale;

/*
* Q1. Amazing Subarrays
Unsolved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
* */
public class AmazingSubarrays {
    public static void main(String[] args) {
        String s = "LDABI";
        System.out.println("Subarray count :"+new AmazingSubarrays().solve(s));
    }

    public int solve(String S) {
        String A = S.toLowerCase(Locale.ROOT);
        int subArrayCount = 0;
        for (int i = 0; i<A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u'){
                subArrayCount += A.length()-i;
            }
        }
        return subArrayCount % 10003;
    }
}
