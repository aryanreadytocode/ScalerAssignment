package advance.dp_1.asg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        List<List<Integer>> answer = subsetUsingBacktrack(input);
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

    private static List<List<Integer>> subsetUsingBacktrack(List<Integer> input) {
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        subsetBacktrack(index, input, new ArrayList<>(), res);
        return res;
    }

    private static void subsetBacktrack(int index, List<Integer> input, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i<input.size(); i++) {
            curr.add(input.get(i));
            subsetBacktrack(i+1, input, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
