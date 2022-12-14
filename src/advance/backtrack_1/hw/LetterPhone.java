package advance.backtrack_1.hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {

    public static void main(String[] args) {
        String input = "012456789";
        List<String> result = new LetterPhone().letterCombinations(input);
        System.out.println(result.toString());
    }


    private ArrayList<String > res;
    private Map<Character, String> stringCorrespondToDigitsMap;
    public ArrayList<String> letterCombinations(String A) {
        int index = 0;
        StringBuilder path = new StringBuilder();
        res = new ArrayList<>();
        stringCorrespondToDigitsMap = new HashMap<>();
        stringCorrespondToDigitsMap.put('0', "0" );
        stringCorrespondToDigitsMap.put('1', "1" );
        stringCorrespondToDigitsMap.put('2', "abc" );
        stringCorrespondToDigitsMap.put('3', "def" );
        stringCorrespondToDigitsMap.put('4', "ghi" );
        stringCorrespondToDigitsMap.put('5', "jkl" );
        stringCorrespondToDigitsMap.put('6', "mno" );
        stringCorrespondToDigitsMap.put('7', "pqrs" );
        stringCorrespondToDigitsMap.put('8', "tuv" );
        stringCorrespondToDigitsMap.put('9', "wxyz" );
        combinations(index, path, A);
        return res;
    }

    private void combinations(int index, StringBuilder path, String input) {
        // sanity check
        if (index < 0 || index>path.length())
            return;
        if (input.isEmpty())
            return;
        // base case
        if (index == input.length()) {
            res.add(path.toString());
            return;
        }

        // backtrack calls
        String stringCorrespondsToDigit = stringCorrespondToDigitsMap.get(input.charAt(index));
        for (int i = 0; i<stringCorrespondsToDigit.length(); i++) {
            path.append(stringCorrespondsToDigit.charAt(i));
            combinations(index+1, path, input);
            path.deleteCharAt(path.length()-1);
        }
    }
}
