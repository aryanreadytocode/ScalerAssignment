package Arrays.IntroToArray;

import java.util.Scanner;

/*
* Problem Description

Write a program to print maximum and minimum elements of the input array A of size N where you have to take integer N and further N elements as input from user.



Problem Constraints

1 <= N <= 1000

1 <= A <= 1000



Input Format

A single line representing N followed by N integers of the array A



Output Format

A single line containing two space separated integers representing maximum and minimum elements of the input array.



Example Input

Input 1:

5 1 2 3 4 5
Input 2:

4 10 50 40 80


Example Output

Output 1:

5 1
Output 2:

80 10*/
public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // get length of array
        int arrayLength = sc.nextInt();

        // get elements of array
        int[] array = new int[arrayLength];
        for(int i = 0; i< arrayLength; i++){
            int element = sc.nextInt();
            array[i] = element;
        }
        findMaxMin(array);
    }

    private static void findMaxMin(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int ele: array){
            if (ele>maxValue)
                maxValue = ele;
            if (ele<minValue)
                minValue = ele;
        }
        System.out.println(maxValue+" "+minValue);
    }
}
