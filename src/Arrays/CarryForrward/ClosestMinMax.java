package Arrays.CarryForrward;

import java.util.ArrayList;

/*
* Problem Description
Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array

and atleast one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3]
* */
public class ClosestMinMax {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        /*list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(4);
        list.add(6);
        list.add(3);*/
        list.add(814);
        list.add(761 );
        list.add(697);
        list.add(483);
        list.add(981);
        System.out.println(new ClosestMinMax().solve(list));
    }

    public int solve(ArrayList<Integer> A) {
        // find min and max value form array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer ele : A){
            if (ele>max)
                max = ele;
            if (ele<min)
                min = ele;
        }
        int length = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < A.size(); i++){
            if (A.get(i) == min)
                minIndex = i;
            if (A.get(i) == max)
                maxIndex = i;

            if (minIndex!=-1 && maxIndex!=-1){
                length = Math.min(length, Math.abs(maxIndex-minIndex)+1);
            }
        }


        return length;
    }
}
