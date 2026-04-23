# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[TreeNode]
        """
        def findMiddle(head):
            prev = None
            slow = fast = head

            while fast and fast.next:
                prev = slow
                slow = slow.next
                fast = fast.next.next

            if prev:
                prev.next = None

            return slow

        if not head:
            return 

        mid = findMiddle(head)

        root = TreeNode(mid.val)

        if head == mid:
            return root

        root.left = self.sortedListToBST(head)
        root.right = self.sortedListToBST(mid.next)

        return root