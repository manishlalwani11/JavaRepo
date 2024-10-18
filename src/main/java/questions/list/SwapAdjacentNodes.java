package questions.list;

public class SwapAdjacentNodes {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(7);

        ListNode res = swapNodes(l1);
    }

    private static ListNode swapNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // p -> 2 -> 4 -> 1 -> 7
        // p -> 4 -> 2

        while (head != null && head.next != null) {

            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = head;
            head = head.next;
        }

        return dummy;
    }
}
