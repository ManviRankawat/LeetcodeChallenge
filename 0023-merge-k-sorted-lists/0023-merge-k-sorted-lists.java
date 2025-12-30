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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i + interval < lists.length; i+= interval * 2){
                lists[i] = merge2List(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    private ListNode merge2List(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
                current.next = h1;
                h1 = h1.next;
            }else{
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }
        if(h1 != null){
            current.next = h1;
            h1 = h1.next;
        }
        if(h2 != null){
            current.next = h2;
            h2 = h2.next;
        }
        return dummy.next;
    }
}