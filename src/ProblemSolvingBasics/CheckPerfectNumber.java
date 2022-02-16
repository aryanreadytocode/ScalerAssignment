package ProblemSolvingBasics;

import java.util.Scanner;

/*
*Problem Description
You are given N positive integers.
For each given integer A, you have to tell whether it is a perfect number or not.
Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

Problem Constraints
1 <= N <= 10
1 <= A <= 106

Input Format
First line of the input contains a single integer N.
Each of the next N lines contains a single integer A.

Output Format
In a seperate line, print YES if a given integer is perfect, else print NO.

Example Input
Input 1:
 2
 4
 6
Input 2:
 1
 3

Example Output
Output 1:
 NO
 YES
Output 2:
 NO

Example Explanation
Explanation 1:
 For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
 For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
Explanation 2:
 For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3.
* */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];
        for (int n = 0; n < count; n++) {
            int element = sc.nextInt();
            array[n] = element;
        }

        for (Integer ele : array) {
            System.out.println(printPerfectNumber(ele));
        }

    }

    private static String printPerfectNumber(Integer ele) {
        int perfectNumber = 0;
        for (int i = 1; i * i <= ele; i++) {
            if (ele % i == 0) {
                perfectNumber += i;
                if (i != 1 &&  i * i != ele)
                    perfectNumber += ele/i;
                }
            }
        if (perfectNumber == ele)
            return "YES";
        else
            return "NO";
    }
}
