package Intermediate.striing;

import java.util.ArrayList;
/*
* Problem Description

Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.



Problem Constraints

1<=N<=100000


Input Format

First argument is a string A of size N.



Output Format

Return the resultant string.



Example Input

A="AbcaZeoB"



Example Output

"bc###bc###"



Example Explanation

First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
Delete all the uppercase letters so string A becomes "bcaeobcaeo".
Now replace vowel with '#'.
A becomes "bc###bc###".
* */
public class StringOperations {

    public static void main(String[] args) {
        String s = "hgUe";
        System.out.println(new StringOperations().solve(s));
    }

    public String solve1(String A) {
        StringBuilder sb = new StringBuilder(A);
        StringBuilder res = new StringBuilder(A);
        ArrayList<Character> vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('i');
        vowel.add('e');
        vowel.add('o');
        vowel.add('u');
        sb.append(A);
        res.append(A);

        int deleteCount = 0; //hgUehgUe
        int n= sb.length();
        for(int i = 0; i<n; i++) {
            if(sb.charAt(i)>=65 && sb.charAt(i)<=90){
                res.deleteCharAt(i-deleteCount);
                deleteCount++;
            }
        }
        n = res.length();
        for(int i = 0; i<n; i++) {
            if (vowel.contains(res.charAt(i))){
                res.setCharAt(i, '#');
            }
        }
        return res.toString();
    }

    public String solve(String A) {
        A += A;
        int n = A.length();
        ArrayList<Character> vowel = new ArrayList<>();
        vowel.add('a');
        vowel.add('i');
        vowel.add('e');
        vowel.add('o');
        vowel.add('u');
        StringBuilder res = new StringBuilder();
        for (int i = 0; i<n; i++){
            if(A.charAt(i)>='a' && A.charAt(i)<='z') {
                if (vowel.contains(A.charAt(i))) {
                    res.append('#');
                }else {
                    res.append(A.charAt(i));
                }
            }
        }
        return res.toString();
    }



    }
