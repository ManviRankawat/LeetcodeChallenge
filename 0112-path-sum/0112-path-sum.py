# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def hasPathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: bool
        """
        
        def dfs(node, targetSum):
            
            if not node:
                return False
            if node.val == targetSum and not node.left and not node.right:
                return True
            if dfs(node.left, targetSum - node.val) or dfs(node.right, targetSum - node.val):
                return True
            return False

        return dfs(root, targetSum)

