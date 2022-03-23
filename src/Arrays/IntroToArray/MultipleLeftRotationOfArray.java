package Arrays.IntroToArray;

import java.util.ArrayList;
/*
* Problem Description

Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.



Problem Constraints

1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format

The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format

Return the resultant matrix.


Example Input

Input 1:

    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:


    A = [5, 17, 100, 11]
    B = [1]




Example Output

Output 1:

    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


Output 2:


    [ [17, 100, 11, 5] ]



Example Explanation

for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]
* */
public class MultipleLeftRotationOfArray {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list2.add(2);
        list2.add(3);


        new MultipleLeftRotationOfArray().solve(list1, list2);
    }

    public void solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        for (int rotation: B){
            if (rotation>A.size())
                rotation %= A.size();
            ArrayList<Integer> arrayList = new ArrayList<>(A);
            reverseArray(arrayList, 0, A.size()-1);
            reverseArray(arrayList, 0, (A.size()-1)-rotation);
            reverseArray(arrayList, A.size()-rotation, A.size()-1);
            arrays.add(arrayList);
        }
            System.out.println(arrays);
//        return arrays;
    }

    private void reverseArray(ArrayList<Integer> list, int from, int to) {
        while (from<to){
            list.set(from, list.get(to)+list.get(from));
            list.set(to, list.get(from)-list.get(to));
            list.set(from, list.get(from)-list.get(to));
            to--;
            from++;
        }
    }
}
