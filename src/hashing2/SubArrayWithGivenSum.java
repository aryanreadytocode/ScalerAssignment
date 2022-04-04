package hashing2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
//        A : [ 5, 10, 20, 100, 105 ]
//        B : 110
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(new SubArrayWithGivenSum().solve1(al, 5));
    }
    public ArrayList<Integer> solve1(ArrayList<Integer> A, int B) {
        //public static int[] subArraySum(int arr[], int n, int sum)
        long curr_sum = A.get(0);
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        int start = 0, i;
        // Pick a starting point
        for (i = 1; i <=n; i++) {
            // If curr_sum exceeds the sum,
            // then remove the starting elements
            while (curr_sum > B && start < i - 1) {
                curr_sum = curr_sum - A.get(start);
                start++;
            }

            // If curr_sum becomes equal to B,
            // then return true
            if (curr_sum == B) {
                for (int ind = start; ind< i; ind++ ) {
                    ans.clear();
                    ans.add(A.get(ind));
                }
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + A.get(i);
        }
        return ans;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i<A.size(); i++) {
            res.clear();
            res.add(A.get(i));
            sum = A.get(i);
            for (int j = i+1; j<A.size(); j++) {
                res.add(A.get(j));
                sum += A.get(j);
                if(sum == B){
                    return res;
                }else if(sum > B)
                    break;
            }
        }
        if(sum != B) {
            res.clear();
            res.add(-1);
        }
        return res;
    }


}
