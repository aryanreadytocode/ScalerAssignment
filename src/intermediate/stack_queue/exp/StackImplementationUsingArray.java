package intermediate.stack_queue.exp;

import java.sql.Array;

public class StackImplementationUsingArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        stack.push(5);
        stack.push(8);
        stack.push(9);
//        stack.push(-1);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        stack.pop();
        System.out.println(stack.top());
//        stack.pop();

    }
}

class Stack<T> {

    private final int[] array;
    private  int count;

    public Stack(int size) {
        // fixing size to 100, we can tack array of size
        array = new int[size];
        count = -1;
    }

    public void push(int element) {
        if (count == array.length-1) {
            System.out.println("Stack Overflow");
        } else {
            count++;
            array[count] = element;
        }
    }

    public void pop() {
        if (count ==-1){
            System.out.println("Empty Stack");
        }else {
            count--;
        }
    }

    public int top() {
        if (count == -1) {
            System.out.println("Empty Stack");
            return -1;
        }else {
            return array[count];
        }
    }
}
