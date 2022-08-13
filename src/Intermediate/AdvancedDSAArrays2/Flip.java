package Intermediate.AdvancedDSAArrays2;

import java.util.ArrayList;

public class Flip {
    public static void main(String[] args) {
        String a = "1101010001 ";
//        String a = "1101010001";
//        String a = "101";
        System.out.println(new Flip().flip(a));
    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> res = new ArrayList<>();
        int endIndex = 0;
        int startIndex = 0;
        int maxSum = 0;
        int currentSum = 0;
        int size = A.length();
        char[] charArr = A.toCharArray();
        // 1101010001
        for (int i = 0; i < size; i++) {
            char c = charArr[i];
            if (c == '0') {
                currentSum++;
            } else {
                currentSum--;
            }


            if (maxSum < currentSum) {
                res.clear();
                maxSum = currentSum;
                endIndex = i;
                endIndex = endIndex+1;
                res.add(startIndex+1);
                res.add(endIndex);
            }
            if (currentSum<0) {
                currentSum = 0;
                startIndex = i+1;
            }
        }

        return res;
    }
}
