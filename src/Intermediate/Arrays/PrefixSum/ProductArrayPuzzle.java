package Intermediate.Arrays.PrefixSum;

import java.util.ArrayList;

/*
* Given an array of integers A, find and return the product array of same size where i'th eement of the product array will be equal to the product of all the elements divided by the i'th element of the array.

Note: It is always possible to form the product array with integer (32 bit) values.


Input Format

The only argument given is the integer array A.
Output Format

Return the product array.
Constraints

1 <= length of the array <= 1000
1 <= A[i] <= 10
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]
See Expected O
* */
public class ProductArrayPuzzle {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int product= 1;
        for (Integer element : A){
            product *= element;
        }
        ArrayList<Integer> resList = new ArrayList<>(A.size());

        for (Integer data: A){
            resList.add(product/data);
        }
        return resList;
    }


}
