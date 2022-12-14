package advance.backtrack_1.hw;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        String input = "))())()))(()((";
        ArrayList<String> result = new RemoveInvalidParentheses().removeInvalidParenthesis(input, new ArrayList<>());
        System.out.println(result);
    }

    static boolean checkParenthesis(Character chars) {
        return chars == ')' || chars == '(';
    }

    static boolean checkValidString(String s) {
        int count = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public ArrayList<String> removeInvalidParenthesis(String s, ArrayList<String > res) {
        if (s.isEmpty())
            return res;

        // visit set to ignore already visited string
        HashSet<String> visitSet = new HashSet<>();


        // queue to maintain BFS
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;

        // pushing given string as starting node into queue.
        q.add(s);
        visitSet.add(s);
        while (!q.isEmpty()) {
            s = q.peek(); q.remove();
            if (checkValidString(s)) {
                res.add(s);
                // if answer is found, make level tree so
                // that valid string of only that level are processed
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i<s.length(); i++) {
                if (!checkParenthesis(s.charAt(i)))
                    continue;
                // removing parenthesis from str and
                // pushing into queue, if not already visited
                temp = s.substring(0, i) + s.substring(i+1);
                if (!visitSet.contains(temp)){
                    q.add(temp);
                    visitSet.add(temp);
                }
            }
        }
        return res;
    }



    //// using back track DPS causing Time Limit Exceeded Exception

    public ArrayList<String> solve(String A) {
        ArrayList<String> ans = new ArrayList<>();
        // get min no of parenthesis need to remove to make string valid
        int minRem = getMin(A);
         return validString(A, minRem, ans);
    }

    private ArrayList<String> validString(String input, int minRemoval, ArrayList<String> ans) {

        // base case
        if (minRemoval == 0) {
            if (getMin(input) == 0) {
                if (!ans.contains(input)) {
                    ans.add(input);
                }
            }
            return ans;
        }

        // recurrence relationship
        for (int i = 0; i<input.length(); i++) {
            String left = input.substring(0,i);
            String right = input.substring(i+1);
            validString(left+right, minRemoval-1, ans);
        }
        return ans;
    }

    private int getMin(String A) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(')
                st.push('(');
            else if (c == ')') {
                if (st.size() == 0)
                    st.push(')');
                else if (st.peek() == '(')
                    st.pop();
                else if (st.peek() == ')')
                    st.push(')');
            }
        }
        return st.size();
    }
}