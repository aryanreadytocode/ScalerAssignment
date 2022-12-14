package advance.backtrack_2.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum {
    public static void main(String[] args) {
        int[] A = {2, 3, 6, 7};
        ArrayList<Integer> al = new ArrayList<>();
        int B = 7;
        for (int i: A ) {
            al.add(i);
        }
        ArrayList<ArrayList<Integer>> ans = new CombinationSum().combinationSum(al, B);
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
        HashSet<Integer> hs = new HashSet<>(A);
        ArrayList<Integer> al = new ArrayList<>(hs);
        Collections.sort(al);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tempArr = new ArrayList<>();
        int index = 0;

        solve(al, ans, tempArr, B, index);
        return ans;
    }

    private void solve(ArrayList<Integer> input, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tempArr,
                       int target, int index)   {
        // sanity check
        if (target<0)
            return;

        //base condition
        if (target == 0) {
            ans.add(new ArrayList<>(tempArr));
            return;
        }
        // recurrence relationship
        for (int i = index; i<input.size(); i++) {
            // check if sum
            if (target-input.get(i) >= 0) {
                tempArr.add(input.get(i));
                solve(input, ans, tempArr, target-input.get(i), i);
                tempArr.remove(input.get(i));
            }
        }
    }

}
