# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def goodNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def dfs(node, max_so_far):
            if node is None:
                return 0
            is_good = 1 if node.val >= max_so_far else 0
            new_max = max(node.val, max_so_far)
            return is_good + dfs(node.left, new_max) + dfs(node.right, new_max)

        return dfs(root, float("-inf"))