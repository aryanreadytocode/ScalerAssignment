package advance.LinkedList3.asg;

import advance.LinkedList2.ListNode;

import java.util.HashMap;

public class PartitionList {

    public static void main(String[] args) {
        int[] A = {1, 4, 3, 2, 5, 2};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        int count = 1;
        while (count < A.length) {
            temp.next = new ListNode(A[count]);
            temp = temp.next;
            count++;
        }
        ListNode ans = partition(head, 3);
        System.out.println("Ans :"+ans);
    }

    public static ListNode partition(ListNode A, int B) {
        ListNode temp = A;
        ListNode lh = null;
        ListNode rh = null;
        ListNode l = null;
        ListNode r = null;

        while (temp != null) {
            if (temp.val < B) {
                if (lh == null) {
                    lh = new ListNode(temp.val);
                    l = lh;
                }else {
                    l.next = new ListNode(temp.val);
                    l = l.next;
                }
            } else {
                if (rh == null) {
                    rh = new ListNode(temp.val);
                    r = rh;
                } else {
                    r.next = new ListNode(temp.val);
                    r = r.next;
                }
            }
            temp = temp.next;
        }
        if (lh == null)
            return rh;
        else if (rh == null)
            return lh;
        else
            l.next = rh;
        return lh;
    }
}
