package Intermediate.Arrays.Subarrays;

import java.util.ArrayList;

/*
* Problem Description
You are given an integer array A of length N comprising of 0's & 1's, and an integer B.

You have to tell all the indices of array A that can act as a centre of 2 * B + 1 length 0-1 alternating subarray.

A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.



Problem Constraints
1 <= N <= 105

A[i] equals to 0 or 1.

0 <= B <= (N - 1) / 2



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer array containing indices(0-based) in sorted order. If no such index exists, return an empty integer array.



Example Input
Input 1:

 A = [1, 0, 1, 0, 1]
 B = 1
Input 2:

 A = [0, 0, 0, 1, 1, 0, 1]
 B = 0


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [0, 1, 2, 3, 4, 5, 6]
* */
public class AlternatingSubarraysEasy {
    public static void main(String[] args) {
        /*0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0*/

        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(0);
        al.add(1);
        al.add(1);
        al.add(1);
        al.add(0);
        al.add(1);
        al.add(1);
        al.add(1);
        al.add(1);
        al.add(0);
        System.out.println(new AlternatingSubarraysEasy().solve1(al, 2));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>(A.size());
        int lengthSub = B * 2 + 1;
        if (lengthSub == 1) {
            for (int k = 0; k < A.size(); k++) {
                res.add(k);
            }
            return res;
        }
        int sum = 0;
        for (int i = 0; i < lengthSub; i++) {
            sum += A.get(i);
        }
        if (A.get(0) == 0 && sum == (lengthSub - 1) / 2)
            res.add(lengthSub / 2);
        else if (A.get(0) == 1 && sum == (lengthSub + 1) / 2)
            res.add(lengthSub / 2);

        for (int j = 1; j <= A.size() - lengthSub; j++) {
            sum = sum - A.get(j - 1) + A.get(j + lengthSub - 1);

            if ((A.get(j) == 0 && sum == (lengthSub - 1) / 2) || (A.get(j) == 1 && sum == (lengthSub + 1) / 2))
                res.add((j + lengthSub + 1) / 2);
        }
        return res;

    }

    /*0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0*/

    public ArrayList<Integer> solve1(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>(A.size());
        if(B==0){
            for(int i = 0; i<A.size(); i++){
                res.add(i);
            }
            return res;
        }

        int length = 2*B+1;
        for(int i = 0; i<A.size()-(length-1); i++){
            boolean status = true;
            for(int j = i; j<i+((length+1)/2); j++){
                if(A.get(j).equals(A.get(j+1)) || !A.get(j).equals(A.get(2 * i + (length - 1) - j)) || A.get(i + length / 2).equals(A.get(i + (length / 2) - 1))){
                    status = false;
                    break;
                }

            }
            if(status)
                res.add(i+length/2);
        }
        return res;
    }


}
