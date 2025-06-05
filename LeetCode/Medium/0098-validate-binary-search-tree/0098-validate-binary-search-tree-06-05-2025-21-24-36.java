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
    boolean validate = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
        return validate;
    }

    void dfs(TreeNode node, long less, long more){
        //less < node.val < more
        if(node != null){
            if(less < node.val && node.val < more){
                if(node.left != null) dfs(node.left, less, node.val);
                if(node.right != null) dfs(node.right, node.val, more);
            }
            else {
                validate = false;
                return;
            }
        }
    }
}