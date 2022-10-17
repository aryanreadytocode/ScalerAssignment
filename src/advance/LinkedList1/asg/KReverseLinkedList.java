package advance.LinkedList1.asg;

import advance.LinkedList1.ListNode;

public class KReverseLinkedList {
    public static void main(String[] args) {
        /*int[] A = {1,2,3,4,5,6};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        int count = 1;
        while (count < A.length) {
            temp.next = new ListNode(A[count]);
            temp = temp.next;
            count++;
        }
        ListNode ans = reverseList2(head, 3);
        while (ans !=null) {
            String ptrStr = ans.next!=null ? ans.val+">>" : ""+ans.val;
            System.out.print(ptrStr);
            ans = ans.next;
        }*/

        LinkedLists.insert_node(1, 1);
        LinkedLists.insert_node(2, 2);
        LinkedLists.insert_node(2, 3);
        LinkedLists.insert_node(3, 5);
        System.out.println(LinkedLists.head.data);
        LinkedLists.delete_node(1);
        LinkedLists.delete_node(2);
        LinkedLists.delete_node(2);
    }

    public static ListNode reverseList(ListNode A, int B) {
        ListNode prev = null;
        ListNode current = A;
        ListNode future = null;
        int count = 0;
        while (current!=null && count<B) {
            future = current.next;
            current.next = prev;

            prev = current;
            current = future;
            count++;
        }
        if (future !=null)
            A.next = reverseList(future, B);
        return prev;
    }

    public static ListNode reverseList2(ListNode A, int B) {
        ListNode prev = null;
        ListNode current = A;
        ListNode future = null;
        ListNode head = null;

        while (current.next != null) {
            head = current;
            prev = null;
            int count = 0;
            while (current.next!=null && count< B) {
                future = current.next;
                current.next = prev;
                prev = current;
                current = future;
                count++;
            }
            head.next = current;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode A, int B) {
        int lengthOfLL = findLength(A);
        if (lengthOfLL ==  1)
            return A;
        ListNode temp = A;
        ListNode prev = null;
        ListNode current = temp;
        int count = 0;
        // reverse upto bth position from starting.
        while (count < B) {
            ListNode future = current.next;
            current.next = prev;

            prev = current;
            current = future;
            count++;
        }
        if (lengthOfLL == B)
            return prev;
        // find tail of newly created linked list prev -> 2>>1>>null
        ListNode temp1 = prev;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = current;
        A = prev;
        // find the value of node position from where need to reverse from back
        ListNode slow = A;
        ListNode fast = A;
        count = 0;
        while (count < B){
            fast = fast.next;
            count++;
        }
        while (fast!= null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        prev = null;
        current = slow.next;
        count = 0;
        while (count < B) {
            ListNode future = current.next;
            current.next = prev;

            prev = current;
            current = future;
            count++;
        }
        slow.next = prev;

        return A;

    }

    private static int findLength(ListNode a) {
        int count = 0;
        while (a!= null) {
            a = a.next;
            count++;
        }
        return count;
    }
}
