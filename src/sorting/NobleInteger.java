package sorting;

import java.util.ArrayList;
import java.util.Collections;

/*
* Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.



Problem Constraints
1 <= |A| <= 2*105
1 <= A[i] <= 107


Input Format
First and only argument is an integer array A.



Output Format
Return 1 if any such integer p is present else, return -1.



Example Input
Input 1:

 A = [3, 2, 1, 3]
Input 2:

 A = [1, 1, 3, 3]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 For integer 2, there are 2 greater elements in the array..
Explanation 2:

 There exist no integer satisfying the required conditions.
* */
public class NobleInteger {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(6);
        al.add(2);
//        al.add(3);

        System.out.println(new NobleInteger().solve(al));
    }

    public int solve(ArrayList<Integer> A) {
        A.sort(Collections.reverseOrder());
        int ans = -1;
        int ge = 0;
        if (ge == A.get(0)){
            ans = 1;
            return ans;
        }
        for (int i = 1; i<A.size(); i++){
            if(A.get(i) != A.get(i-1))
                ge = i;
            if(A.get(i) == ge){
                ans = 1;
                break;
            }
        }
        return ans;
    }

}
