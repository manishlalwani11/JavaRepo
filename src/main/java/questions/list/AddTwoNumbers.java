package questions.list;

/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]
    Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

    Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.

 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        // TODO fix for this input  l1 = [9,9,9,9,9,9,9]
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next.next = new ListNode(9);

        // TODO fix for this input l2 = [9,9,9,9]
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next.next = new ListNode(9);

        ListNode dummy1 = new ListNode(0);
        dummy1.next = head1;
        ListNode l1 = head1;

        ListNode dummy2 = new ListNode(0);
        dummy2.next = head2;
        ListNode l2 = head2;


        ListNode resultHead = addTwoNumbers(l1, l2);
    }

    private static ListNode addTwoNumbers(ListNode l1,
                                          ListNode l2) {

        int sum = 0;
        int carryForwardValue = 0;
        int prevCarryForwardValue = 0;

        ListNode resDummy = new ListNode(0);
        ListNode l3 = resDummy;

        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val + prevCarryForwardValue;
            carryForwardValue = carryForwardValueExists(sum, carryForwardValue);

            if (l1.next == null) {
                if (carryForwardValue == 0) {
                    l3.next = new ListNode(sum % 10 + carryForwardValue);
                } else {
                    l3.next = new ListNode(sum % 10);
                    l3.next.next = new ListNode(carryForwardValue);
                }
            } else {
                l3.next = new ListNode(sum % 10);
            }
            l3 = l3.next;
            prevCarryForwardValue = carryForwardValue;
            carryForwardValue = 0;
            l1 = l1.next;
            l2 = l2.next;

        }
        // l1 = [2,4,3]
        // l1 = [5,6]   ==> [7,0,4]

        while (l1 != null) {
            sum = l1.val + prevCarryForwardValue;
            carryForwardValue = carryForwardValueExists(sum, carryForwardValue);

            if (l1.next == null) {
                if (carryForwardValue == 0) {
                    l3.next = new ListNode(sum % 10 + carryForwardValue);
                } else {
                    l3.next = new ListNode(sum % 10);
                    l3.next.next = new ListNode(carryForwardValue);
                }
            } else {
                l3.next = new ListNode(sum % 10);
            }
            prevCarryForwardValue = carryForwardValue;
            carryForwardValue = 0;
            l1 = l1.next;
            l3 = l3.next;
        }

        while (l2 != null) {
            sum = l2.val + prevCarryForwardValue;
            carryForwardValue = carryForwardValueExists(sum, carryForwardValue);
            if (l2.next == null) {
                if (carryForwardValue == 0) {
                    l3.next = new ListNode(sum % 10 + carryForwardValue);
                } else {
                    l3.next = new ListNode(sum % 10);
                    l3.next.next = new ListNode(carryForwardValue);
                }
            } else {
                l3.next = new ListNode(sum % 10);
            }
            prevCarryForwardValue = carryForwardValue;
            carryForwardValue = 0;
            l2 = l2.next;
            l3 = l3.next;
        }

        return resDummy.next;
    }

    private static int carryForwardValueExists(int sum,
                                               int carryForwardValue) {
        carryForwardValue = sum / 10;
        return carryForwardValue;
    }
}
