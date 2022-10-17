package advance.LinkedList1.hw;

import Intermediate.LInked;
import advance.LinkedList1.ListNode;

public class RemoveNthNodeFromListEnd {

    public static void main(String[] args) {
        int[] A = {1};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        int count = 1;
        while (count < A.length) {
            temp.next = new ListNode(A[count]);
            temp = temp.next;
            count++;
        }
        ListNode ans = removeNthFromEnd(head, 1);
        System.out.println("Ans :"+ans);
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode temp = A;
        ListNode slow = A;
        ListNode fast = A;
        int count = 0;
        while (count < B && fast != null) {
            fast = fast.next;
            count++;
        }
        if (fast == null) {
            temp = slow.next;
            slow.next = null;
            return temp;
        }


        while(fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return A;
    }
}
