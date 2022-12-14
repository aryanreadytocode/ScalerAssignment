package advance.backtrack_1.asg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(6);
        input.add(6);
        input.add(3);
        input.add(3);
        input.add(6);
        input.add(5);
        ArrayList<ArrayList<Integer>> answer = subsetUsingBacktrack(input);
        for (int i = 0; i< answer.size(); i++) {
            List<Integer> val = answer.get(i);
            System.out.println(val.toString());
        }
    }

    private static List<List<Integer>> res;
    private static List<List<Integer>> subsetIterative(List<Integer> input) {
       res = new ArrayList<>();
       res.add(new ArrayList<>()); // res[[]]
       for (int i = 0; i< input.size(); i++) { // size = 3;
           int n = res.size();// 1 | 2
           for (int j = 0; j<n; j++) { //
               List<Integer> temp = new ArrayList<>(res.get(j)); // tem[] = [] | []
               temp.add(input.get(i)); // temp[] = [1]; | [2]  input[1,2,3]
               res.add(temp); // res[[],[1]] |
           }
       }
       return res;
    }

    private static ArrayList<ArrayList<Integer>> subsetUsingBacktrack(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int index = 0;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        subsetBacktrack(index, input, new ArrayList<>(), res, set);
        return res;
    }

    private static void subsetBacktrack(int index, List<Integer> input, List<Integer> curr, List<ArrayList<Integer>> res,
                                        HashSet<ArrayList<Integer>> set) {
        if (!set.contains(curr)) {
            res.add(new ArrayList<>(curr));
            set.add((ArrayList<Integer>) curr);
        }
        for (int i = index; i<input.size(); i++) {
            curr.add(input.get(i));
            subsetBacktrack(i+1, input, curr, res, set);
            curr.remove(curr.size()-1);
        }
    }
}
