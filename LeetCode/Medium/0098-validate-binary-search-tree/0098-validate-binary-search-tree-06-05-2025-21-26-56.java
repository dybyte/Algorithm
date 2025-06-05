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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }

    boolean dfs(TreeNode node, long less, long more){
        //less < node.val < more
        if(node != null){
            if(less < node.val && node.val < more){
                return dfs(node.left, less, node.val) && dfs(node.right, node.val, more);
            }
            else {
                return false;
            }
        }
        return true;
    }
}