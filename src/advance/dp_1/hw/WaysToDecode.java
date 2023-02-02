package advance.dp_1.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaysToDecode {

    static int res = 0;
    public static void main(String[] args) {
        String input = "123";
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i<input.length(); i++) {
            dp.add(1);
        }
        Collections.fill(dp, 1);
        int count = decode(input, 0,dp);
        System.out.println("Ways to decode: "+count);
    }

    private static int decode(String input, int index, ArrayList<Integer> dp) {
        if (index >= input.length())
            return 1;
        if (dp.contains(index))
            return dp.get(index);
        if (input.charAt(index) == '0')
            return 0;

        res = decode(input, index+1, dp);
        if (index + 1 < input.length() && (input.charAt(index) == '1' ||
                input.charAt(index) == '2' && "0123456".contains(""+input.charAt(index)))) {
            res += decode(input, index+2, dp);
        }
        dp.add(index, res);
        return res;

    }
}
