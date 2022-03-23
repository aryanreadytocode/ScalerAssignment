package Arrays.IntroToArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Problem Description

You are given an integer T denoting the number of test cases. For each test case, you are given an integer array A.

You have to put the odd and even elements of array A in 2 separate arrays and print the new arrays.

NOTE: Array elements should have same relative order as in A.



Problem Constraints

1 <= T <= 10

1 <= |A| <= 105

1 <= A[i] <= 109



Input Format

First line of the input contains a single integer T.

For each test case:

First line consists of a single integer |A| denoting the length of array.
Second line consists of |A| space separated integers denoting the elements of array A.


Output Format

For each test case:

First line should contain an array of space separated integers containing all the odd elements of array A
Second line should contain an array of space separated integers containing all the even elements of array A


Example Input

Input 1:

 2
 5
 1 2 3 4 5
 3
 4 3 2
Input 2:

 2
 3
 2 2 2
 2
 1 1


Example Output

Output 1:

 1 3 5
 2 4
 3
 4 2
Output 2:


 2 2 2
 1 1



Example Explanation

Explanation 1:

 Test Case 1:
 Odd elements in the array(in the order they occur) are: 1, 3, 5.
 Even elements in the array(in the order they occur) are: 2, 4.

 Test Case 2
 Odd elements in the array(in the order they occur) are: 3.
 Even elements in the array(in the order they occur) are: 4, 2.
Explanation 2:

 Test Case 1:
 There are no odd elements in the array.
 Even elements in the array(in the order they occur) are: 2, 2, 2.

 Test Case 2
 Odd elements in the array(in the order they occur) are: 1, 1.
 There are no even elements in the array.*/
public class SeparateOddEven {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //get no of test cases
        List<int[]> arrays = new ArrayList<>();
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            //get length of array
            int length = scanner.nextInt();
            length = length<0?-length:length;
            int[] arr = new int[length];
            //put elements in array
            for (int j = 0; j< length; j++){
                int arele = scanner.nextInt();
                arr[j] = arele;
            }
            arrays.add(arr);
        }

        for (int[] arr: arrays){
            printOddEven(arr);
        }
    }

    private static void printOddEven(int[] arr) {
        List<Integer> evenList = new ArrayList<>();
        for (int ele: arr){
            if (ele%2!=0)
                System.out.print(ele+" ");
            else
                evenList.add(ele);
        }
        System.out.println();

        for (int ele: evenList){
            System.out.print(ele+" ");
        }
        System.out.println();

    }
}
