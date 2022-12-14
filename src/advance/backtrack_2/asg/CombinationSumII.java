package advance.backtrack_2.asg;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {

    public static void main(String[] args) {
//        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int[] arr = {2, 1, 3};
//        int B = 8;
        int B = 3;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i: arr) {
            al.add(i);
        }
        ArrayList<ArrayList<Integer>> ans = new CombinationSumII().combinationSum(al, B);
        for (ArrayList<Integer> alI: ans) {
            System.out.print("[");
            for (int inte: alI) {
                System.out.print(inte);
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int index = 0;
        solve(A, B, ans, temp, index);
        return ans;
    }

    private void solve(ArrayList<Integer> input, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int index) {
        // sanity check
        if (target<0 || input.isEmpty())
            return;

        // base condition
        if (target == 0) {
            if (!ans.contains(temp))
                ans.add(new ArrayList<>(temp));
            return;
        }

        // recurrence relationship
        for (int i = index; i<input.size(); i++) {
            int val = input.get(i);
            if (target-val>=0) {
                // do step
                temp.add(val);
                index = i+1;
                solve(input, (target - val), ans, temp, index);
                temp.remove(temp.indexOf(val));
            }
        }
    }
}
