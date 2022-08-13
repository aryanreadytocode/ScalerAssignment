package advance.maths_gdc.asg;

import java.util.Arrays;

/*
* Problem Description
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



Problem Constraints
1 <= N <= 10000

1 <= A[i] <= 109



Input Format
The first and only argument given is the integer array A.



Output Format
Find and return the original numbers which are used to calculate the GCD array in any order.



Example Input
Input 1:

 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:

 A = [5, 5, 5, 15]


Example Output
Output 1:

 [2, 8, 10]
Output 2:

 [5, 15]


Example Explanation
Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
* */
public class AllGcdPair {

    public static void main(String[] args) {
//        int[] A = {1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11 };
        int[] A = {2,2,2,2,2,2,2,8,10};
        System.out.println(solve(A));
    }

    /*public static int[] solve(int[] A) {
        Arrays.sort(A);
        reverse(A);
        int n = A.length;

        int freq[] = new int[A[0] + 1];
        for (int i = 0; i < n; i++) {
            int value = A[i];
            freq[value]++;
        }

        int size = (int) Math.sqrt(n);
        int brr[] = new int[size], x= 0, l= 0;

         for (int i = 0; i<n; i++) {
             if(freq[A[i]] > 0 & l<size) {
                 brr[l] = A[i];
                 freq[brr[l]]--;
                 l++;
                 for (int j = 0 ; j< l; j++) {
                     if (i!=j) {
                         x = find(A[i], brr[j]);
                         freq[x] -=2;
                     }
                 }
             }
         }
         return brr;
    }

    private static void reverse(int[] Arr) {
        int last = Arr.length-1;
        int middle = Arr.length/2;
        for(int i = 0; i<=middle; i++) {
            int temp = Arr[i];
            Arr[i] = Arr[last-i];
            Arr[last-i] = temp;
        }
    }

    public static int find(int a, int b) {
        if (a == 0 || b == 0)
            return Math.max(a, b);
        return find(b % a, a);
    }*/

    public static int[] solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        reverse(A);
        int[] freq = new int[A[0]+1];
        for(int i = 0; i<n; i++) {
            freq[A[i]]++;
        }
        int size = (int) Math.sqrt(n);
        int resArr[] = new int[size], gcd = 0, resArrLength = 0;
        for (int j = 0; j<n-1; j++) {
            if (freq[A[j]]>0 & resArrLength < size) {
                resArr[resArrLength] = A[j];
                freq[resArr[resArrLength]]--;
                resArrLength++;

                for (int k = 0; k < resArrLength; k++) {
                    if (k != j) {
                        gcd = find(A[j], resArr[k]);
                        freq[gcd] -= 2;
                    }
                }
            }
        }
        return resArr;
    }

    public static int find(int a, int b) {
        if (a == 0 || b == 0)
            return Math.max(a, b);
        return find(b % a, a);
    }
    public static void reverse(int[] A) {
        int last = A.length-1;
        int middle = A.length/2;
        for (int i = 0; i<=middle; i++) {
            int temp = A[last-i];
            A[last-i] = A[i];
            A[i] = temp;
        }
    }
}
