/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(isSametree(root, subRoot)) return true;

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean isSametree(TreeNode t, TreeNode s){
        if(t == null && s == null) return true;
        if(t == null || s == null) return false;

        if(t.val == s.val){
            return isSametree(t.right, s.right) && isSametree(t.left, s.left);
        }
        return false;
    }
}