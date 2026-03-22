# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[str]
        """
        result = []
        if not root:
            return result
        if root and not root.right and not root.left:
            result.append(str(root.val))
        
        childPaths = self.binaryTreePaths(root.right) + self.binaryTreePaths(root.left)

        for path in childPaths:
            newPath = str(root.val) + "->" + path
            result.append(newPath)

        return result