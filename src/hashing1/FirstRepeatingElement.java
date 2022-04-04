package hashing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/*
* Problem Description
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
The first and only argument is an integer array A of size N.



Output Format
Return an integer denoting the first repeating element.



Example Input
Input 1:

 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:

 A = [6, 10, 5, 4, 9, 120]


Example Output
Output 1:

 5
Output 2:

 -1


Example Explanation
Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1
* */
public class FirstRepeatingElement {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(15);
        al.add(1);
        al.add(10);
        al.add(5);
        al.add(19);
        al.add(19);
        al.add(3);
        al.add(5);
        al.add(6);
        al.add(6);
        al.add(2);
        al.add(8);
        al.add(12);
        al.add(16);
        al.add(3);
        System.out.println(new FirstRepeatingElement().solve(al));
    }

    public int solve1(ArrayList<Integer> A) {
        LinkedHashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        for (Integer i : A) {
            lhm.put(i, lhm.getOrDefault(i, 0) + 1);
        }
        int ans = -1;
        for (Integer i : A) {
            if (lhm.get(i) > 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> vis = new HashMap<Integer, Integer>();
        int ans = -1;
        for (int i = A.size() - 1; i >= 0; --i) {
            if (vis.containsKey(A.get(i))) {
                ans = A.get(i);
            } else {
                vis.put(A.get(i), 1);
            }
        }
        return ans;
    }
}
