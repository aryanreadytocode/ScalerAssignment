package advance.stack1.asg;

import java.util.Stack;

public class DoubleCharacterTrouble {

    public static void main(String[] args) {
        String ss = solve("aaaaa");
        System.out.println(ss);
    }

    public static String solve(String A) {
        if (A.length() == 0 || A.length() == 1)
            return A;
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        res = res.append(A.charAt(0));
        st.push(A.charAt(0));
        int count = 1;
        while (count < A.length()) {
            char currentChar = A.charAt(count);
            if (st.size()>0) {
                char lastChar = st.peek();
                if (lastChar == currentChar) {
                    st.pop();
                    res = res.deleteCharAt(st.size());
                } else {
                    st.push(currentChar);
                    res = res.append(currentChar);
                }
            }else {
                st.push(currentChar);
                res = res.append(currentChar);
            }
            count++;
        }
        return res.toString();

    }
}
