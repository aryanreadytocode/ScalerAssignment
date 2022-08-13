package Intermediate.SubsequencesAndSubsets;

import java.util.ArrayList;
import java.util.Collections;

/*
* Problem Description
Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a vector of vectors denoting the answer.



Example Input
Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation
Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.
* */
public class Subset {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(new Subset().subsets (al));
    }


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        ArrayList<ArrayList<Integer>> parAl = new ArrayList<>();
        for (int i = 0; i<Math.pow(2,  n); i++) {
            ArrayList<Integer> childAl = new ArrayList<>();
            for (int j= 0; j<n ; j++) {
                if(checkBit(i, j))
                    childAl.add(A.get(j));
            }
            parAl.add(childAl);
        }
        return parAl;
    }

    public boolean checkBit(int i, int j) {
        return ((i & (1<<j)) > 0);
    }
}
