package advance.backtrack_2.exp;

import java.util.ArrayList;

public class PossiblePalindromePartition {

    static ArrayList<ArrayList<String>> ans = new ArrayList<>();
    static ArrayList<String> currentPart = new ArrayList<>();
    static int startIndex = 0;

    public static void main(String[] args) {
//        String s = "abaabcdcb";
        String s = "abaa";
        generatePP(0, s);
        for (ArrayList<String> d: ans) {
            for (String d1: d) {
                System.out.println(d1);
            }
        }
    }

    private static void generatePP(int index, String input) {

        // sanity check
        if (index<0 || index>= input.length())
            return;

        // base case
        if (index == input.length()-1) {
            if (isPalindrome(input, startIndex, index)) {
                currentPart.add(input.substring(startIndex, index+1));
                ans.add(new ArrayList<>(currentPart));
                currentPart.remove(currentPart.size() - 1);
            }
            return;
        }

        // recurrence relation for back tracking
        // Here we can consider two element of choices
        // first either for the given index we should do not partition
        // Do step empty
        // recurrence
        generatePP(index+1, input);
        // Undo step empty

        // Now we should consider second element of choice i.e,
        // we should do partition for given index
        // Do
        if (isPalindrome(input, startIndex, index)) {
            int temp = startIndex;
            startIndex = index + 1;
            currentPart.add(input.substring(temp, index+1));
            // recur call
            generatePP( index + 1, input);
            // Undo
            startIndex = temp;
            currentPart.remove(currentPart.size() - 1);
        }
        return;
    }

    private static boolean isPalindrome(String input, int startIndex, int endIndex) {
        while (startIndex<=endIndex) {
            if (input.charAt(startIndex) != input.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
