package advance.LinkedList2.asg;

import advance.LinkedList2.ListNode;

public class RemoveLoopFromLinkedList {

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        ListNode _6 = new ListNode(6);
        ListNode _7 = new ListNode(7);
        ListNode _8 = new ListNode(8);
        ListNode _9 = new ListNode(9);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        _6.next = _7;
        _7.next = _8;
        _8.next = _9;
        _9.next = null;
        String val = String.valueOf(solve(_1) !=null ? solve(_1).val : null);
        System.out.println((val));

    }

    public static ListNode solve(ListNode A) {
        ListNode meetNode = null;
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = null;
        while (fast.next !=null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetNode = slow;
                break;
            }
        }
        if (meetNode !=null) {
            ListNode left = A;
            ListNode right = meetNode;
            while (left != right) {
                prev = right;
                right = right.next;
                left = left.next;
            }
            prev.next = null;
        }
        return A;
    }
}
