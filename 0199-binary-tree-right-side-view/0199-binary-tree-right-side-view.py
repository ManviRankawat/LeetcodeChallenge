# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        l = {}

        def dfs(node, h):
            if not node: return

            if h not in l:
                l[h]= node.val
            dfs(node.right, h+1)
            dfs(node.left, h+1)

        dfs(root,0)

        return list(l.values())
        
        