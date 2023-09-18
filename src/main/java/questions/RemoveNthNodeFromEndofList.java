package questions;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = null;
        ListNode currentNode = dummy;
        int i = 0;
        while (i <= n) {
            p2 = currentNode.next;
            currentNode = currentNode.next;
            i++;
        }

        while (p2 != null) {
            p2 = currentNode.next;
            currentNode = currentNode.next;
            //increaseP1(p1);
            p1 = p1.next;
        }

        ListNode nodeTobeDeleted = p1.next;
        p1.next = nodeTobeDeleted.next;

        return dummy.next;

    }

}
