package advance.LinkedList3.hw;

import advance.LinkedList2.ListNode;

public class FlattenALinkedList {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5,};
        int[][] A1 = {{2,3}, {5,7}, {4,5}, {5,8}, {6,7}};
        ListNode temp = new ListNode(A[0]);
        ListNode head = temp;
        ListNode downN = temp;
        downN.down = new ListNode(A1[0][0]);
        downN = temp.down;
        downN.down = new ListNode(A1[0][1]);
        downN = temp.down;

        int count = 1;
        ListNode nextN = temp;
        while (count < A.length) {

            nextN.next = new ListNode(A[count]);
            nextN = nextN.next;
            int count1 = 0;
            while (count1 < A1[count].length) {
                downN = new ListNode(A1[count][count1]);
                nextN.down = downN;

                count1++;
            }
            count++;
        }
        ListNode ans = flatten(head);
        System.out.println("Ans :" + ans);
    }

    static ListNode flatten(ListNode root) {
        ListNode temp = root;
        ListNode head = temp;
        ListNode newLL = head;

        // convert to single one directional linked list
        while (temp != null) {
            ListNode downN = temp.next;
            while (downN!= null) {
                newLL.next = downN;
                downN = downN.down;
                newLL = newLL.next;
            }
            temp = temp.next;
            newLL.next = temp;
        }

        // do partition from middle
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode r = slow.next;
        slow.next = null;
        ListNode l = head;
        return null;
    }
}
