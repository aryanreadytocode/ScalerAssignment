package Arrays.PrefixSum;

import java.util.ArrayList;

/*
* Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints

1<=n<=1e5
-1e5<=A[i]<=1e5


Input Format

First argument contains an array A of integers of size N


Output Format

Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input

Input 1:
A=[2, 1, 6, 4]
Input 2:

A=[1, 1, 1]


Example Output

Output 1:
1
Output 2:

3


Example Explanation

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.
Explanation 2:

 Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3.
* */
public class CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAndArrayElement {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(6);
        al.add(4);
        System.out.println(new CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAndArrayElement().solve3(al));
    }

    public int solve3(ArrayList<Integer> A){
        int os = 0;
        int es = 0;
        int count = 0;

        for (int i = 0; i< A.size(); i++){
            if (i % 2 == 0) {
                es += A.get(i);
            }else {
                os += A.get(i);
            }
        }
        int evenElementsSum = A.get(0);
        int oddElementsSum = 0;

        int currentEvenSum = os;
        int currentOddSum = es - evenElementsSum;

        if (currentEvenSum==currentOddSum)
            count++;


        for (int i = 1; i<A.size(); i++){
            if (i%2==0){
                evenElementsSum += A.get(i);
                currentEvenSum = evenElementsSum + os - oddElementsSum - A.get(i);
                currentOddSum = es + oddElementsSum - evenElementsSum;
            }else {
                oddElementsSum += A.get(i);
                currentEvenSum = evenElementsSum + os - oddElementsSum;
                currentOddSum = oddElementsSum + es - evenElementsSum - A.get(i);
            }
            if (currentEvenSum == currentOddSum)
                count++;
        }
        return count;
    }

    public int solve(ArrayList<Integer> A) {
        // get the prefix array sum
        ArrayList<Integer> psl = new ArrayList<>(A.size());
        psl.add(0, A.get(0));
        for (int i = 1; i < A.size(); i++) {
            int sum = psl.get(i - 1) + A.get(i);
            psl.add(i, sum);
        }
        int es = 0;
        int os = 0;
        for (int i = 0; i < psl.size(); i++) {
            if (i % 2 == 0) {
                es += psl.get(i);
            } else {
                os += psl.get(i);
            }
        }
        int dif = os - es;
        dif = dif < 0 ? -dif : dif;
        int index = -1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == dif)
                index = i;
        }
        return index;
    }

    public int solve1(ArrayList<Integer> A) {

        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            int es = 0;
            int os = 0;
            for (int j = 0; j < A.size(); j++) {
                if (j != i) {
                    if (j < i) {
                        if (j % 2 == 0)
                            es += A.get(j);
                        else
                            os += A.get(j);
                    } else {
                        if ((j - 1 )% 2 == 0)
                            es += A.get(j);
                        else
                            os += A.get(j);
                    }
                }
            }
            if (os == es)
                count++;
        }
        return count;
    }

    /*public int solve2(ArrayList<Integer> A) {

        // get the prefix sum array
        ArrayList<Integer> psl = new ArrayList<>();
        psl.add(0, A.get(0));
        for (int i = 1; i<A.size(); i++) {
            int sum = psl.get(i-1)+A.get(i);
            psl.add(i , sum);
        }
        int es = 0;
        int os = 0;
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> psl1 = new ArrayList<>(psl);
            psl1.remove(i);

        }


    }*/



    }
