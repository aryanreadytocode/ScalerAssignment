package Intermediate.StackAndQueues;

import java.util.ArrayList;

/*
* Problem Description
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:

All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.


Problem Constraints
1 <= Number of Function calls <= 107



Input Format
Functions will be called by the checker code automatically.



Output Format
Each function should return the values as defined by the problem statement.



Example Input
Input 1:

push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()
Input 2:

getMin()
pop()
top()


Example Output
Output 1:

 -2 1 2
Output 2:

 -1 -1


Example Explanation
Explanation 1:

Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.
Explanation 2:

Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.
* */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }

    private ArrayList<Integer> mainAL = new ArrayList<>();
    private ArrayList<Integer> minAL = new ArrayList<>();
    int top = -1;
    int min = -1;
    int topMinAL = -1;

    public void push(int x) {
        mainAL.add(++top, x);
        if (topMinAL == -1) {
            min = x;
            minAL.add(++topMinAL, x);
        } else if (x <= min) {
            min = x;
            minAL.add(++topMinAL, min);
        }

    }

    public void pop() {
        if (top == -1) {
            return;
        } else {
            if (mainAL.get(top).equals(minAL.get(topMinAL))) {
                topMinAL--;
                min = topMinAL >= 0 ? minAL.get(topMinAL) : -1;
            }
            top--;
        }
    }

    public int top() {
        return top < 0 ? -1 : mainAL.get(top);
    }

    public int getMin() {
        return min;
    }
}
