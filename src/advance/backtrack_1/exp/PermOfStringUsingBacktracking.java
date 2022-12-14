package advance.backtrack_1.exp;

import java.util.ArrayList;
import java.util.List;

public class PermOfStringUsingBacktracking {

    private static String inputString;
    private static List<String> answerList;
    public static void main(String[] args) {
        int pos = 0;
        inputString = "abcd";
        answerList = new ArrayList<>();
        permUsingBacktrack(pos);
        System.out.println(answerList.toString());
    }

    private static void permUsingBacktrack(int pos) {
        // check for sanity if the input is valid or not
        if (pos < 0 || pos >= inputString.length())
            return;
        // check for base case if the pos equal to length-1 of input string
        if (pos == inputString.length()-1)
            answerList.add(inputString);

        // recursive call using backtracking
        for (int i = pos; i<inputString.length(); i++) {
            // Do the swap
            StringBuilder sb = new StringBuilder(inputString);
            sb.setCharAt(i, inputString.charAt(pos));
            sb.setCharAt(pos, inputString.charAt(i));
            inputString = sb.toString();
            //recurrence call
            permUsingBacktrack(pos+1);
            //do unod
            sb.setCharAt(i, inputString.charAt(pos));
            sb.setCharAt(pos, inputString.charAt(i));
            inputString = sb.toString();
        }
    }
}
