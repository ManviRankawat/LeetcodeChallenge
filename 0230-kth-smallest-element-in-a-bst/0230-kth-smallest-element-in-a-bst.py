class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        def inorder(node):
            if not node or self.count >= k:
                return
            
            inorder(node.left)  # Visit left subtree
            
            self.count += 1
            if self.count == k:  # Found kth smallest element
                self.result = node.val
                return
            
            inorder(node.right)  # Visit right subtree
        
        self.count = 0
        self.result = None
        inorder(root)
        return self.result
