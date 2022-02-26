package Arrays;

import java.sql.Array;
import java.util.Scanner;

/*
* Problem Description

You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.

NOTE: You can use extra memory.



Problem Constraints

1 <= |A| <= 106

1 <= A[i] <= 109

1 <= B <= 109



Input Format

First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
Second line contains a single integer B



Output Format

Print an array of integers which is the Bth right rotation of input array A, on a separate line.



Example Input

Input 1:

 4 1 2 3 4
 2
Input 2:

 3 1 2 2
 3


Example Output

Output 1:

 3 4 1 2
Output 2:

 1 2 2


Example Explanation

Explanation 1:

 [1,2,3,4] => [4,1,2,3] => [3,4,1,2]

Explanation 2:


 [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]
* */
public class ReverseRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // get length of array
        int arrayLength = sc.nextInt();
        arrayLength = changeSign(arrayLength);

        // get elements of array
        int[] array = new int[arrayLength];
        for(int i = 0; i< arrayLength; i++){
            int element = sc.nextInt();
            array[i] = element;
        }

        // get no of rotation
        sc.nextLine();
        int rotation = sc.nextInt();
        rotation = changeSign(rotation);
        if (rotation>arrayLength)
            rotation = rotation%arrayLength;

        rotateArray(array, rotation);
    }

    private static void rotateArray(int[] array, int rotation) {
        reverseArray(array, 0, array.length - 1);
        reverseArray(array, 0, rotation - 1);
        reverseArray(array, rotation, array.length-1);

        for (int j : array) {
            System.out.print(j+" ");
        }

    }

    public static int changeSign(int num){
        return num<0 ? -num: num;
    }

    public static void reverseArray(int[] array, int from, int to){
        while (from<to){
            array[from] = array[to]+array[from];
            array[to] = array[from]-array[to];
            array[from] = array[from]-array[to];
            to--;
            from++;
        }
    }

}
