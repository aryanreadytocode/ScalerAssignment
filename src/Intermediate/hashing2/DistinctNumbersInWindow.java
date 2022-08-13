package Intermediate.hashing2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
* Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
* */
public class DistinctNumbersInWindow {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(1);
        al.add(3);
        al.add(4);
        al.add(3);
        System.out.println(dNums(al,3));
    }
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> resArr = new ArrayList<>();
        int size = A.size();
        // prepare HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i<B; i++) {
            int ele = A.get(i);
            if (hm.containsKey(ele)) {
                int freq = hm.get(ele);
                hm.put(ele, ++freq);
            }else {
                hm.put(A.get(i),1);
            }
        }
        resArr.add(hm.size());
        int freq;
        for (int i = 1; i<size-B+1; i++) {
            int prevEle = A.get(i-1);
            int ele = A.get(i+B-1);
            if (hm.containsKey(ele)) {
                freq = hm.get(ele);
                hm.put(ele, ++freq);
            }else {
                hm.put(ele, 1);
            }
            freq = hm.get(prevEle);
            if (freq ==1)
                hm.remove(prevEle);
            else
                hm.put(prevEle, --freq);
            resArr.add(hm.size());
        }
        return resArr;
    }

    public static ArrayList<Integer> dNums1(ArrayList<Integer> A, int B) {
        ArrayList<Integer> resArr = new ArrayList<>();
        int size = A.size();
        for (int i = 0; i <size-B+1; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j<i+B; j++) {
                set.add(A.get(j));
            }
            resArr.add(set.size());
        }
        return resArr;
    }
}
