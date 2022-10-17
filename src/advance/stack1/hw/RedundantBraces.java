package advance.stack1.hw;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {
        String A = "a";
        int ans = braces(A);
        System.out.println(ans);
    }

    public static int braces(String A) {
        Stack<Character> charStack = new Stack<>();
        int count = 0;
        int length = A.length();
        while (count < length) {
            char sym = A.charAt(count);
            if (sym == (')')){
                int counter= 0;
                while (!charStack.isEmpty() && charStack.peek() != '(') {
                    charStack.pop();
                    counter++;
                }
                charStack.pop();
                if (counter <= 1)
                    return 1;
            }else {
                charStack.push(sym);
            }
            count++;
        }
        return 0;
    }
}
