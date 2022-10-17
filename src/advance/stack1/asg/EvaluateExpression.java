package advance.stack1.asg;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        String[] st = { "5", "1", "2", "+", "4", "*", "+", "3", "-"};
        int ans = evalRPN(st);
        System.out.println(ans+"");
    }

    public static int evalRPN(String[] A) {
        // insert expression in stack
        Stack<String> st = new Stack<>();
        int count = 0;
        int size = A.length;
        while (count < size) {
            String data = A[count];
            String r;
            String l;
            if (data.equals("+")) {
                r = st.pop();
                l = st.pop();
                st.push(String.valueOf(Integer.parseInt(l)+Integer.parseInt(r)));
            }else if (data.equals("*")) {
                r = st.pop();
                l = st.pop();
                st.push(String.valueOf(Integer.parseInt(l)*Integer.parseInt(r)));
            }else if (data.equals("-")) {
                r = st.pop();
                l = st.pop();
                st.push(String.valueOf(Integer.parseInt(l)-Integer.parseInt(r)));
            }else if (data.equals("/")) {
                r = st.pop();
                l = st.pop();
                st.push(String.valueOf(Integer.parseInt(l)/Integer.parseInt(r)));
            }else {
                st.push(A[count]);
            }
            count++;
        }
        return Integer.parseInt(st.peek());
    }

    private static int evalExp(Stack<String> st, String ch) {
        if (st == null)
            return 0;
        if (st.peek() == null)
            return 0;
        String r = st.pop();
        String l = st.pop();

        if (r.equals("+") || r.equals("-")  || r.equals("*") || r.equals("/")){
            r = String.valueOf(evalExp(st, r));
        }
        if (l.equals("+") || l.equals("-")  || l.equals("*") || l.equals("/")){
            l = String.valueOf(evalExp(st, l));
        }
        if (ch.equals("+")) {
            return Integer.parseInt(l)+Integer.parseInt(r);
        }else if (ch.equals("-")) {
            return Integer.parseInt(l)-Integer.parseInt(r);
        }if (ch.equals("*")) {
            return Integer.parseInt(l)*Integer.parseInt(r);
        }else  {
            return Integer.parseInt(l)/Integer.parseInt(r);
        }
    }
}
