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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list,root,0);
        return list;
    }

    void dfs(List<Integer> list, TreeNode treeNode, int depth){
        if(treeNode == null) return;
        if(list.size()==depth) list.add(treeNode.val);
        dfs(list,treeNode.right,depth+1);
        dfs(list,treeNode.left,depth+1);
    }

    class Node{
        TreeNode treeNode;
        int depth;
        Node (TreeNode treeNode, int depth){
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}