package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
The first argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

* */
public class LargestNumber {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(0);
//        l.add(34);
//        l.add(5);
//        l.add(9);
        System.out.println(new LargestNumber().largestNumber(l));
    }

    public String largestNumber(final List<Integer> A) {

        Comparator<Integer> c = (a, b) -> {
            String a1 = a.toString();
            String b1 = b.toString();
            return (b1+a1).compareTo(a1+b1);
        };

        A.sort(c);
        StringBuilder sb = new StringBuilder();
        for (Integer e : A) {
            sb.append(e);
        }
        return Character.getNumericValue(sb.charAt(0)) == 0 ? "0" : sb.toString();

    }
}
