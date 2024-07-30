package questions.list;

import java.util.Collections;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

        // i/p => 1 1 2 3 3
        // o/p => 1 2 3

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode node = deleteDuplicates(head);

    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return (ListNode) Collections.EMPTY_LIST;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = head;
        ListNode current = head.next;

        while (current != null) {
            if (p1.val == current.val) {
                current = current.next;
            } else {
                p1.next = current;
                p1 = current;
                current = current.next;
            }
        }

        p1.next = null;

        return dummy.next;
    }
}
