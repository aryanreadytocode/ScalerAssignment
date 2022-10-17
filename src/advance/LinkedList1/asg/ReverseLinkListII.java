package advance.LinkedList1.asg;

import advance.LinkedList1.ListNode;

public class ReverseLinkListII {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        int count = 1;
        while (count < A.length) {
            temp.next = new ListNode(A[count]);
            temp = temp.next;
            count++;
        }
        ListNode ans = reverseBetween(head, 1, 6);
        while (ans != null) {
            String ptrStr = ans.next != null ? ans.val + ">>" : "" + ans.val;
            System.out.print(ptrStr);
            ans = ans.next;
        }
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode temp = new ListNode(-1);
        temp.next = A;
        int count = 1;
        ListNode leftEnd = temp;
        while (count < B) {
            leftEnd = leftEnd.next;
            count++;
        }
        ListNode rightStart = leftEnd.next;
        ListNode current = rightStart;
        ListNode prev = null;
        ListNode future = null;
        count = 0;
        while (count< (C-B)+1) {
            future = current.next;
            current.next = prev;
            prev = current;
            current = future;
            count++;
        }
        rightStart.next = current;
        leftEnd.next = prev;
        return temp.next;
    }
}
