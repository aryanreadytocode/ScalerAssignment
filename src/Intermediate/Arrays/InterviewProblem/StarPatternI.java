package Intermediate.Arrays.InterviewProblem;

import java.util.Scanner;

/*
* Problem Description

Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.

See example for clarifications over the pattern.



Problem Constraints

1 <= N <= 1000



Input Format

First line is an integer N



Output Format

N lines conatining only char '*' as per the question.



Example Input

Input 1:

4
Input 2:

6


Example Output

Output 1:

********
***  ***
**    **
*      *
*      *
**    **
***  ***
********
Output 2:

************
*****  *****
****    ****
***      ***
**        **
*          *
*          *
**        **
***      ***
****    ****
*****  *****
************
* */
public class StarPatternI {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        for(int i =0; i< data; i++){
            for(int j = 0; j<2*data; j++){
                if(i>0 && j>data-1-i && j<data+i){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for(int i =0; i< data; i++){
            for(int j = 0; j<2*data; j++){
                if(i<data && j>i && j<((2*data-1)-i)){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }

}
