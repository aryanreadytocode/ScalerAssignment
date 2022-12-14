package advance.backtrack_1.asg;

import java.util.*;

public class AllUniquePermutations {

    public static void main(String[] args) {
//        int[] A = {1, 2, 2};
        int[] A = {0, 0, 0, 1, 9};
        ArrayList<Integer> al = new ArrayList<>();
        for (int n : A) {
            al.add(n);
        }
        ArrayList<ArrayList<Integer>> res = new AllUniquePermutations().permute(al);
        for (List<Integer> data: res) {
            System.out.println(data.toString());
        }

    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int index = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        return calculatePermute(index, res, A);
    }

    private ArrayList<ArrayList<Integer>> calculatePermute(int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> input) {
        // sanity check
        if (index < 0 || index >= input.size()) {
            return null;
        }

        // base case
        if (index == input.size()-1) {
            // check if same array is present or not
            if (!res.contains(input))
                res.add(new ArrayList<>(input));
            return res;
        }
        // backtracking
        // do
        for (int i = index; i<input.size(); i++) {
            // check if shifting makes no diff
            if (i != index && input.get(index).equals(input.get(i))) {
                continue;
            }
//            if (i >0 && input.get(i).equals(input.get(i-1)))
//                continue;
            int temp = input.get(index);
            input.set(index, input.get(i));
            input.set(i, temp);

            // recur call
            calculatePermute(index+1, res, input);

            //undo
            temp = input.get(index);
            input.set(index, input.get(i));
            input.set(i, temp);

        }
        return res;
    }

}
