package Intermediate.Arrays.IntroToArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Problem Description

You are given an integer T (Number of test cases). For each test case, you are given array A and an integer B. You have to tell whether B is present in array A or not.



Problem Constraints

1 <= T <= 10

1 <= |A| <= 105

1 <= A[i], B <= 109



Input Format

First line of the input contains a single integer T.

Next, each of the test case consists of 2 lines:

First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
Second line contains a single integer B


Output Format

For each test case, print on a separate line 1 if the element exists, else print 0.



Example Input

Input 1:

 1
 5 4 1 5 9 1
 5
Input 2:

 1
 3 7 7 2
 1


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

  B = 5  is present at position 3 in A
Explanation 2:

  B = 1  is not present in A. */
public class FindNumberInArray {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        // get no of test cases
        int testCases = sc.nextInt();
        List<int[]> arrayList = new ArrayList<>();
        List<Integer> searchList = new ArrayList<>();
        testCases = testCases<0?-testCases:testCases;
        for (int i = 0; i < testCases; i++) {
            // get length of array
            int arrayLength = sc.nextInt();
            arrayLength = arrayLength < 0 ? -arrayLength : arrayLength;

            //get elements of array
            int k = 0;
            int[] arr = new int[arrayLength];
            while (k < arrayLength) {
                int ele = sc.nextInt();
                arr[k] = ele;
                k++;
            }
            arrayList.add(arr);
            //get number to find in array
            int findNum = sc.nextInt();
            searchList.add(findNum);
        }
        for (int i = 0; i < searchList.size(); i++) {
            searchNumberInArray(arrayList.get(i), searchList.get(i));
        }
    }

    private static void searchNumberInArray(int[] arr, int findNum) {
        int found = 0;
        for (int ele : arr) {
            if (ele == findNum){
                found = 1;
                break;
            }
        }
        System.out.println(found);
    }

}
