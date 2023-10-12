package intermediate.stack_queue.exp;

public class StackImplementationUsingLLAtTail {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        stack.push(5);
        stack.push(8);
        stack.push(9);
        System.out.println(stack.top());
        stack.pop();
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

class StackLL<T> {

    private Node head;
    private Node temp;

    public StackLL() {

    }

    public void push(int element) {
        Node n;
        if (head == null) {
            head = new Node(element);
            temp = head;
        } else {
            n = new Node(element);
            head.next = n;
            head = n;
        }
    }

    public int pop() {
        Node temp1 = temp;
        while (temp1.next.next !=null) {
            temp1 = temp.next;
        }
        head = temp1;
        return head.data;
    }

    public int top() {
        if (head == null)
            return -1;
        else
            return head.data;
    }
}
