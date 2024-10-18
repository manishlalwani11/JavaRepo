/*
package questions.list;


import java.util.Stack;

public class AddTwoNumbersII {

*/
/*
MEDIUM
https://leetcode.com/problems/add-two-numbers-ii/
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

 *//*

    public static void main(String[] args) {
        // l1 = [7,2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode();
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode();
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(4);

        ListNode result = addTwoNumbersII( l1, l2);

    }

    private static ListNode addTwoNumbersII(ListNode l1,
                                            ListNode l2) {

        ListNode dummy = new ListNode();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1.next != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode result;
        int carryForward = 0;
        int previousCarryForward = 0;
        while(s1.isEmpty() && s2.isEmpty()) {
            sum = s1.pop() + s2.pop() + previousCarryForward;
            carryForward = checkForCarryForward(sum);

            result = new ListNode(sum % 10);
            if (result.next != null) {
                result = result.next;
            }
            previousCarryForward = carryForward;
            carryForward = 0;



        }

    }

    private static int checkForCarryForward(int sum) {
        return sum / 10;

    }
}
*/
