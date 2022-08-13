package Intermediate;

public class LInked {
    static Node head;
    static int length;
    public static class Node{
        Node next;
        int val;
        Node(int val){
            this.val=val;
        }
    }

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(position>length+1) {
            return;
        }

        Node newNode = new Node(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        }
        else {
            int counter=1;
            Node curr = head;
            while(counter<position-1){
                curr=curr.next;
                counter++;
            }
            newNode.next=curr.next;
            curr.next=newNode;
        }
        length++;
    }


    public static void delete_node(int position) {
        // @params position, integer
        if(position>length) {
            return ;
        }
        if(position==1){
            head=head.next;
        }else{

            int counter=1;
            Node curr=head;
            while(counter<position-1){
                counter++;
                curr=curr.next;
            }
            curr.next=curr.next.next;
        }
        length--;
    }

    public static void print_ll() {
        // Output each element followed by a space
        if(length == 0) {
            return;
        }
        Node node=head;
        while (node.next != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.print(node.val);
    }
}
