package advance.LinkedList2.hw;

import advance.LinkedList2.ListNode;

import java.util.List;

public class SortList {

    public static void main(String[] args) {
        SortList sortList = new SortList();
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(2);
        System.out.println(sortList.sortList(head));
    }

    public ListNode sortList(ListNode A) {

        return mergeSort(A);
    }

    private ListNode mergeSort(ListNode A) {
        if (A == null)
            return null;
        if (A.next == null)
            return A;

        ListNode midNode = findMid(A);
        ListNode headR = midNode.next;
        midNode.next = null;
        ListNode headL = A;
        ListNode sortedL = mergeSort(headL);
        ListNode sortedR = mergeSort(headR);
        return mergeTwoLists(sortedL, sortedR);
    }

    public ListNode findMid(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null && B == null)
            return null;
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                temp.next = A;
                temp = A;
                A = A.next;
            } else {
                temp.next = B;
                temp = B;
                B = B.next;
            }
        }

        while (A != null) {
            temp.next = A;
            temp = A;
            A = A.next;
        }

        while (B != null) {
            temp.next = B;
            temp = B;
            B = B.next;
        }
        return ans.next;
    }
}
