# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        dummy = ListNode(0)
        dummy.next = head
        point = dummy

        while point.next and point.next.next:
            swap1 = point.next
            swap2 = point.next.next

            swap1.next = swap2.next
            swap2.next = swap1

            point.next = swap2
            point = swap1

        return dummy.next