package Intermediate.sorting;

import java.util.ArrayList;

/*
* Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2


Input Format
First and only argument of input contains an integer array A.


Output Format
Return an integer array in asked order


Example Input
Input 1 :
    A = [0 1 2 0 1 2]
Input 2:

    A = [0]


Example Output
Output 1:
    [0 0 1 1 2 2]
Output 2:

    [0]


Example Explanation
Explanation 1:
    [0 0 1 1 2 2] is the required order.
* */
public class SortByColor {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(0);
        System.out.println(new SortByColor().sortColors1(integers));
    }
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        ArrayList<Integer> zeroArr = new ArrayList<>();
        ArrayList<Integer> oneArr = new ArrayList<>();
        ArrayList<Integer> twoArr = new ArrayList<>();
        for(Integer i: A){
            if(i == 0){
                zeroArr.add(0);
            } else if(i == 1){
                oneArr.add(1);
            } else {
                twoArr.add(2);
            }
        }

        zeroArr.addAll(oneArr);
        zeroArr.addAll(twoArr);
        return zeroArr;
    }

    public ArrayList<Integer> sortColors1(ArrayList<Integer> A) {
        int zero = 0;
        int two = A.size()-1;
        for(int i = 0; i<two;){
            if(A.get(i)==0){
                int temp = A.get(zero);
                A.set(zero, 0);
                A.set(i, temp);
                i++;
                zero++;
            }else if (A.get(i) == 2){
                int temp = A.get(two);
                A.set(i, temp);
                A.set(two, 2);
                two--;
            }else
                i++;
        }
        return A;
    }
}
