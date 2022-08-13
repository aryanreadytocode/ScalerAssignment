package Intermediate.StackAndQueues;

import java.util.ArrayList;

/*
* Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[]


Example Output
Output 1:

 1
Output 2:

 0
Output 3:

 1


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
* */
public class BalancedParanthesis {

    public static void main(String[] args) {
//        String A = "{{{{{{{{{{{{{{{{{{{{{{((((((((((((([[[[[[[[[]]]]]]]]])))))))))))))}}}}}}}}}}}}}}}}}}}}}}";
        String   A = "}{";
        System.out.println(new BalancedParanthesis().solve(A));

    }
    public int solve(String A) {
        int topCurl = -1;
        int topPar = -1;
        int topSquare= -1;
        ArrayList<Character> curlArr = new ArrayList<>();
        ArrayList<Character> parArr = new ArrayList<>();
        ArrayList<Character> squareArr = new ArrayList<>();

        char[] chars = A.toCharArray();
        for(char ch : chars) {
            if (ch == '}' || ch == ')' ) {
                if(topPar == -1) {
                    parArr.add(++topPar, ch);
                }else {
                    Character prev = parArr.get(topPar);
                    if(!prev.equals(ch)){
                        topPar--;
                    }else {
                        parArr.add(++topPar, ch);
                    }

                }
            }else if (ch == '[' || ch == ']') {
                if(topSquare == -1) {
                    squareArr.add(++topSquare, ch);
                }else {
                    Character prev = squareArr.get(topSquare);
                    if(!prev.equals(ch)){
                        topSquare--;
                    }else {
                        squareArr.add(++topSquare, ch);
                    }

                }
            }else {
                if(topCurl == -1) {
                    curlArr.add(++topCurl, ch);
                }else {
                    Character prev = curlArr.get(topCurl);
                    if(!prev.equals(ch)){
                        topCurl--;
                    }else {
                        curlArr.add(++topCurl, ch);
                    }

                }
            }
        }
        return (topSquare<0 && topPar<0 && topCurl<0)?1:0;
    }
}
