package Intermediate.hashing2;

import java.util.ArrayList;

/*
* Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 -1


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
* */
public class SubArrayWithGivenSum {
    public static void main(String[] args) {
//        A : [ 5, 10, 20, 100, 105 ]
//        B : 110
//        int[] A = { 15, 2, 48, 19, 28, 22, 44, 2, 32, 46, 46, 24, 1, 23, 49, 26, 23, 17, 17, 46, 4, 30, 40, 36, 20, 5 };
//        int[] A = {5, 10, 20, 100, 105};
        int[] A = {42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37};
        int B = 41;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(5);
        res.add(6);
        res.add(10);
        System.out.println(new SubArrayWithGivenSum().solve1(res, 22));
    }

    public ArrayList<Integer> solve2(int[] A, int B) {
        int sum = 0;
        int size = A.length;
        int removeIndex = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int element = A[i];
            if (element == B) {
                res.add(element);
                return res;
            } else if (element > B) {
                res.clear();
                sum = 0;
                removeIndex++;
            } else {
                sum += element;
                res.add(element);
                if (sum == B) {
                    res.add(element);
                    return res;
                } else if (sum > B) {
                    sum -= A[removeIndex];
                    res.remove(Integer.valueOf(removeIndex));
                    if (sum == B) {
                        return res;
                    }
                    removeIndex++;
                }
            }

        }
        res.clear();
        res.add(-1);
        return res;
    }

    public ArrayList<Integer> solve1(ArrayList<Integer> A, int B) {
        long sum = A.get(0);
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A.get(0));
        int start = 0, i;
        for (i = 1; i < n; i++) {
            sum = sum + A.get(i);
            ans.add(A.get(i));

            while (sum > B) {
                sum = sum - A.get(start);
                ans.remove(A.get(start));
                start++;
            }

            if (sum == B) {
                return ans;
            }


        }
        ans.clear();
        ans.add(-1);
        return ans;
    }

    public ArrayList<Integer> solve(int[] A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            res.clear();
            res.add(A[i]);
            sum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                res.add(A[j]);
                sum += A[j];
                if (sum == B) {
                    return res;
                } else if (sum > B)
                    break;
            }
        }
        if (sum != B) {
            res.clear();
            res.add(-1);
        }
        return res;
    }


}
