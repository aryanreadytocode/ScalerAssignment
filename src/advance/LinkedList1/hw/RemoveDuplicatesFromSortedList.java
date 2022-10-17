package advance.LinkedList1.hw;

import advance.LinkedList1.ListNode;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        int[] A = {1,1,1,1,1,1};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        int count = 1;
        while (count < A.length) {
            temp.next = new ListNode(A[count]);
            temp = temp.next;
            count++;
        }
        ListNode ans = deleteDuplicates(head);
        while (ans !=null) {
            String ptrStr = ans.next!=null ? ans.val+">>" : ""+ans.val;
            System.out.print(ptrStr);
            ans = ans.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode prev = A;
        ListNode current = A.next;
        HashMap<Integer, ListNode> hm = new HashMap<>();
        hm.put(A.val, A);
        while (current != null) {
            if (hm.containsKey(current.val)) {
                prev.next = current.next;
                current.next = null;
                current = prev.next;
            }else {
                hm.put(current.val, current);
                prev = current;
                current = current.next;
            }
        }
       return A;
    }

}
