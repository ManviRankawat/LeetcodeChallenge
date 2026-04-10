# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseList(self, head):
        # Base case: empty list or single node
        if not head or not head.next:
            return head

        # Recurse on the rest of the list
        new_head = self.reverseList(head.next)

        # Reverse the current link
        head.next.next = head
        head.next = None

        return new_head

        
