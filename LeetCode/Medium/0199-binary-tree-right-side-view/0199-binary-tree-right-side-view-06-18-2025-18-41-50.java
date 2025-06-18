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
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root,0));
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            TreeNode treeNode = node.treeNode;
            if(treeNode == null) continue;
            int depth = node.depth;
            
            if(list.size() == depth) list.add(treeNode.val);

            queue.offer(new Node(treeNode.right, depth+1));
            queue.offer(new Node(treeNode.left, depth+1));
        }
        return list;
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