package Intermediate.striing;

import java.util.ArrayList;
/*
* Problem Description
You are given a function to_lower() which takes a character array A as an argument.

Convert each character of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.

Return the lowercase version of the given character array.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return the lowercase version of the given character array.



Example Input
Input 1:

 A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
Input 2:

 A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
Output 2:

 ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Explanation
Explanation 1:

 All the characters in the returned array are in lowercase alphabets.

* */
public class ToLower {

    public static void main(String[] args) {
        ArrayList<Character> al = new ArrayList<>();
        al.add('r');
        al.add('A');
        al.add('J');
        al.add('a');
        al.add('R');
        al.add('y');
        al.add('A');
        al.add('N');
        System.out.println(new ToLower().to_lower(al));
    }

    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        int count = 0;
        for(char c: A) {
            if(c>= 'A' && c<= 'Z') {
                c += 32;
                A.set(count, c);
            }
            count++;
        }
        return A;
    }
}
