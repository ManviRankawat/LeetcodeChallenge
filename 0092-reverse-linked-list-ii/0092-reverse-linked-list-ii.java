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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode curr = pre.next;
        ListNode next = null;
        ListNode prev = null;

        for (int i = 0; i < (right - left + 1); i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        pre.next.next = curr; 
        pre.next = prev;      

        return dummy.next;
    }
}