package advance.LinkedList1.asg;

import advance.LinkedList1.ListNode;

import java.util.List;

public class LinkedLists {

    public static void main(String[] args) {
        LinkedLists.insert_node(1, 1);
        LinkedLists.insert_node(1, 2);
        LinkedLists.insert_node(1, 3);
        LinkedLists.insert_node(1, 4);
        LinkedLists.insert_node(1, 5);

        LinkedLists.print_ll();
        System.out.println();
        LinkedLists.delete_node(1);
        LinkedLists.print_ll();
        System.out.println();
        LinkedLists.delete_node(4);
        LinkedLists.print_ll();
        System.out.println();
        LinkedLists.insert_node(4, 5);
        LinkedLists.print_ll();
        System.out.println();
    }

    public static int size = 0;
    public static Node head = null;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void insert_node(int position, int value) {
        if(position >= 1 && position <= size + 1) {
            Node newNode = new Node(value);

            //at start
            if(position == 1) {
                newNode.next = head;
                head = newNode;
            } else {
                //at any position
                Node temp = head;
                int count = 1;
                while (count < position-1){
                    temp = temp.next;
                    count++;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position >= 1 && position <= size) {

            // at start
            if(position == 1) {
                head = head.next;
            } else {

                // at any position
                Node temp = head;
                int counter = 1;
                while (counter < position - 1) {
                    temp = temp.next;
                    counter++;
                }
                if (temp.next != null)
                    temp.next = temp.next.next;

            }
            size--;
        }
    }

    public static void print_ll() {
        Node current = head;
        while (current != null) {
            String printVal = current.next != null ? current.data + " " : "" + current.data;
            current = current.next;
            System.out.print(printVal);
        }
    }

}
