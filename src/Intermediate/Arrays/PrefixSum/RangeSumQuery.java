package Intermediate.Arrays.PrefixSum;

import java.util.ArrayList;

/*
* Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.



Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
1 <= L <= R <= N


Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.


Output Format
Return an integer array of length M where ith element is the answer for ith query in B.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]
Input 2:

A = [2, 2, 2]
B = [[1, 1], [2, 3]]


Example Output
Output 1:
[10, 5]
Output 2:

[2, 4]


Example Explanation
Explanation 1:
The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[2 ... 3] = 2 + 3 = 5.
Explanation 2:

The sum of all elements of A[1 ... 1] = 2 = 2.
The sum of all elements of A[2 ... 3] = 2 + 2 = 4.
* */
public class RangeSumQuery {
    public static void main(String[] args) {
        /*A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]*/
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        ArrayList<Integer> B1 = new ArrayList<>();
        ArrayList<Integer> B2 = new ArrayList<>();

        B1.add(1);
        B1.add(4);
        B2.add(2);
        B2.add(3);

        B.add(B1);
        B.add(B2);
        System.out.println(new RangeSumQuery().rangeSum(A, B));
    }

    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        // get prefix sum array
        ArrayList<Long> psl = new ArrayList<>();
        psl.add(Long.valueOf(A.get(0)));
        for (int i = 1; i< A.size(); i++){
            long prevSum = psl.get(i-1)+A.get(i);
            psl.add(prevSum);
        }

        int l;
        int r;
        ArrayList<Long> resultList = new ArrayList<>();
        long sum;
        for (ArrayList<Integer> index: B){
            l = index.get(0)-1;
            r = index.get(1)-1;
            if (l == 0)
                sum = psl.get(r);
            else
                sum = psl.get(r)-psl.get(l-1);
            resultList.add(sum);
        }
        return resultList;
    }

}
