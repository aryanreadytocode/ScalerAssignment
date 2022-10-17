package advance.LinkedList2.asg;

import advance.LinkedList2.ListNode;

import java.util.HashMap;
import java.util.logging.Handler;

public class ReorderList {

    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "A");
        hm.get(2);
        hm.size();
        int[] A = {1,2,3,4,5, 6};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        int count = 1;
        while (count < A.length) {
            temp.next = new ListNode(A[count]);
            temp = temp.next;
            count++;
        }
        ListNode ans = reorderList(head);
        System.out.println("Ans :"+ans);
    }

    public static ListNode reorderList(ListNode A) {
        // divide linked list form middle
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode r = slow.next;
        slow.next = null;
        ListNode l = A;
        // reverse right ll
        ListNode prev = null;
        ListNode current = r;
        ListNode future = null;
        while (current != null) {
            future = current.next;
            current.next = prev;
            prev = current;
            current = future;
        }
        r = prev;
        while (r != null && l != null) {
            future = r.next;
            r.next = l.next;
            l.next = r;
            l = l.next.next;
            r = future;
        }
        return A;
    }

    private static ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode future = null;
        while (current !=null) {
            future = current.next;
            current.next = prev;
            prev = current;
            current = future;
        }
        return prev;
    }
}
