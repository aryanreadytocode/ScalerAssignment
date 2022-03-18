package bit_manipulation;

import java.util.ArrayList;

/*
* Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.



Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
The first argument is an array of integers of size N.



Output Format
Return an array of two integers that appear only once.



Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:
[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:
3 and 4 appear only once.
Explanation 2:

1 and 2 appear only once.
* */
public class SingleNumberIII {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int resTemp = 0;
        ArrayList<Integer> resArr = new ArrayList<>();
        for(int i : A){
            resTemp ^= i;
        }
        int temp = resTemp&(-resTemp);
        int res1 = 0;
        int res2 = 0;
        for(int i : A){
            if((i&temp)!=0)
                res1 = res1^i;
            else
                res2 = res2^i;
        }
        if(res2>res1){
            resArr.add(res1);
            resArr.add(res2);
        }else{
            resArr.add(res2);
            resArr.add(res1);
        }

        return resArr;
    }

}
