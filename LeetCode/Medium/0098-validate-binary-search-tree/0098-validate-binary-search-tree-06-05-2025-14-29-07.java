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
        if(root.left != null) dfs(root.left, (long)Integer.MIN_VALUE - 1, root.val);
        if(root.right != null) dfs(root.right, root.val, (long)Integer.MAX_VALUE + 1);
        return validate;
    }

    void dfs(TreeNode treeNode, long less, long more){
        if(treeNode != null){
            if(less < treeNode.val && treeNode.val < more){
                if(treeNode.left != null){
                    dfs(treeNode.left, less, treeNode.val);
                }
                if(treeNode.right != null){
                    dfs(treeNode.right, treeNode.val, more);
                }
            }
            else validate = false;
        }
    }
}