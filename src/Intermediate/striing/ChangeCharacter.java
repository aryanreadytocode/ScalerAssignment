package Intermediate.striing;

import java.util.*;
/*
* Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints

1 <= N <= 100000

0 <= B < N



Input Format

First argument is a string A.

Second argument is an integer B.



Output Format

Return an integer denoting the minimum number of distinct characters in the string.



Example Input

A = "abcabbccd"
B = 3



Example Output

2



Example Explanation

We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
* */
public class ChangeCharacter {
    public static void main(String[] args) {
        String s = "abcd";
        int b = 5;
        System.out.println(new ChangeCharacter().solve(s, b));
    }

    public int solve(String A, int B) {
        char[] A1 = A.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count;
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A1[i])) {
                count = map.get(A1[i])+1;
            }else
                count = 1;
            map.put(A1[i], count);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 97; i <= 122; i++) {
            char ch = (char) i;
            if (map.containsKey(ch))
                list.add(map.get(ch));
        }
        Collections.sort(list);
        int ps = 0;
        for (Integer integer : list) {
            B -= integer;
            ps++;
            if (B < 0) {
                ps--;
                break;
            }
        }
        return Math.max(map.size() - ps, 0);
    }

}
