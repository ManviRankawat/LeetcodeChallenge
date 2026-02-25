# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        totPath = []
        path = []

        def dfs(node, remaining):
            if not node:
                return
            
            path.append(node.val)
            remaining -= node.val

            if not node.left and not node.right and remaining == 0:
                totPath.append(list(path))
            else:
                dfs(node.left, remaining)
                dfs(node.right, remaining)

            path.pop() #backtrack

        dfs(root, targetSum)
        return totPath