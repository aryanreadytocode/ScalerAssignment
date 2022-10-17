package advance.stack1.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String A = "x^y/(a*z)+b";
        String ans = new InfixToPostfix().solve(A);
        System.out.println(ans);
    }

    private static boolean isBracesOpen;

    public int prec(char c)
    {
        // Multiplication and division
        if (c == '*' || c == '/') {
            return 3;
        }

        // Addition and subtraction
        if (c == '+' || c == '-') {
            return 4;
        }

        // Bitwise AND
        if (c == '&') {
            return 8;
        }

        // Bitwise XOR (exclusive or)
        if (c == '^') {
            return 9;
        }

        // Bitwise OR (inclusive or)
        if (c == '|') {
            return 10;
        }

        // add more operators if needed

        return Integer.MAX_VALUE;            // for opening bracket '('
    }

    // Utility function to check if a given token is an operand
    public boolean isOperand(char c)
    {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    public String solve(String infix) {
// base case
        if (infix == null || infix.length() == 0) {
            return infix;
        }

        // create an empty stack for storing operators
        Stack<Character> s = new Stack<>();

        // create a string to store the postfix expression
        String postfix = "";

        // process the infix expression from left to right
        for (char c: infix.toCharArray())
        {
            // Case 1. If the current token is an opening bracket '(',
            // push it into the stack
            if (c == '(') {
                s.add(c);
            }
            // Case 2. If the current token is a closing bracket ')'
            else if (c == ')')
            {
                // pop tokens from the stack until the corresponding opening
                // bracket '(' is removed. Append each operator at the end
                // of the postfix expression
                while (s.peek() != '(') {
                    postfix += s.pop();
                }
                s.pop();
            }

            // Case 3. If the current token is an operand, append it at the end
            // of the postfix expression
            else if (isOperand(c)) {
                postfix += c;
            }

            // Case 4. If the current token is an operator
            else {
                // remove operators from the stack with higher or equal precedence
                // and append them at the end of the postfix expression
                while (!s.isEmpty() && prec(c) >= prec(s.peek())) {
                    postfix += s.pop();
                }

                // finally, push the current operator on top of the stack
                s.add(c);
            }
        }

        // append any remaining operators in the stack at the end
        // of the postfix expression
        while (!s.isEmpty()) {
            postfix += s.pop();
        }

        // return the postfix expression
        return postfix;
    }


    public String solve1(String A) {
        // create two stack one for operators and other for post fix ans
        Stack<Character> operators = new Stack<>();
        Stack<Character> postFix = new Stack<>();
        HashMap<Character, Integer> priority = new HashMap<>();
        priority.put('^', 3);
        priority.put('/', 2);
        priority.put('*', 2);
        priority.put('+', 1);
        priority.put('-', 1);
        int count = 0;
        int length = A.length();
        while (count < length) {
            char stChar = A.charAt(count);
            // checking for the
//            if (stChar == '^' || stChar == '/' || stChar == '*' || stChar == '+' || stChar == '-' || stChar == '(' || stChar == ')') {
            // checking for char is operators or not, if not push to postfix stack.
            if (priority.containsKey(stChar) || stChar == '(' || stChar == ')') {
                // check the priority
                // if higher or equal pop() higher or equal priority to postfix stack if the braces is not there else add to operator stack
                // else add to operator stack
                if (operators.size() == 0) {
                    operators.push(stChar);
                    count++;
                    continue;
                }
                if (priority.containsKey(stChar)  && (priority.get(stChar) <= priority.get(operators.peek())) && !isBracesOpen) {
                    // remove operators from operators stack until top operator of operators stack is less than current operator
                    while (operators.size() > 0 && (priority.get(stChar) <= priority.get(operators.peek()))) {
                        postFix.push(operators.pop());
                    }
                    operators.push(stChar);
                } else {
                    if (stChar == '(') {
                        isBracesOpen = true;
                        operators.push(stChar);
                    } else if (stChar == ')') {
                        stChar = operators.pop();
                        while (stChar != '(') {
                            postFix.push(stChar);
                            stChar = operators.pop();
                        }
                    } else {
                        operators.push(stChar);
                    }
                }
            } else
                postFix.push(stChar);
//            }

            count++;
        }
        return null;
    }


}
