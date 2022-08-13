package Intermediate.striing;

import java.util.ArrayList;

/*
* Problem Description
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".
* */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        /*A = ["abcdefgh", "aefghijk", "abcefgh"]*/
        al.add("abab");
        al.add("ab");
        al.add("abcd");
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(al));
    }

    public String longestCommonPrefix1(ArrayList<String> A) {
        StringBuilder sb = new StringBuilder();
        boolean matched = true;
        String firstString = A.get(0);
        for (int i = 0; i<firstString.length(); i++) {
            char ch1 = firstString.charAt(i);
            for (int j = 1; j<A.size(); j++) {
                String s = A.get(j);
                if(i<s.length()){
                    char ch2 = s.charAt(i);
                    if(ch1 != ch2){
                        matched = false;
                        break;
                    }
                }else {
                    matched = false;
                    break;
                }


            }
            if(matched)
                sb.append(ch1);
            else
                break;
        }
        return sb.toString();

    }

    public String longestCommonPrefix(ArrayList<String> A) {
        int min = Integer.MAX_VALUE;
        String minString = "";
        for (String s: A) {
            if (min>s.length()){
                min = s.length();
                minString = s;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i<minString.length(); i++){
            char ch = minString.charAt(i);
            for (String s : A) {
                if (ch != s.charAt(i))
                    return res.toString();
            }
            res.append(ch);
        }
        return res.toString();
    }


    }
