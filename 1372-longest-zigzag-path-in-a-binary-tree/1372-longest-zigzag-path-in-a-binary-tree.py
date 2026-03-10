# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def longestZigZag(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        self.path = 0
        def dfs(node, left, curr):
            if not node:
                return
            
            self.path = max(self.path, curr)

            if left:
                dfs(node.left, True, 1)
                dfs(node.right, False, curr+1)
            else:
                dfs(node.right, False, 1)
                dfs(node.left, True, curr+1)
        
        dfs(root.right, False, 1)
        dfs(root.left, True, 1)
        return self.path
