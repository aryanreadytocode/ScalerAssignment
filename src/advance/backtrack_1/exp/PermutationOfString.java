package advance.backtrack_1.exp;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "abc";
        List<String> ansList = permutation(s);
        System.out.println(ansList.toString());
    }
    static List<String> answer = new ArrayList<>();
    ;
    public static List<String> permutation(String input) {
        // sanity check
        if (input.length() == 0)
            return null;
        // base condition
        if (input.length() == 1){
            answer.add(input);
            return answer;
        }
        // recursive calls
        for(int i = 0; i< input.length(); i++) {
            char firstChar = input.charAt(i);

            String subProbInput = input.substring(0, i) +
                                            input.substring(i+1, input.length());
            List<String> subProbOutput = permutation(subProbInput);

            for (int j = 0; j< subProbOutput.size(); j++) {
                String s = answer.remove(j);
                if (s.contains(""+firstChar)) {
                    answer.add(j, s);
                } else
                    answer.add(firstChar+s);
            }
        }
        return answer;
    }
}
