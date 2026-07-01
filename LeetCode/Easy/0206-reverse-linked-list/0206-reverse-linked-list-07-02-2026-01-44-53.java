/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode node;
    ListNode answer = new ListNode(-1, null);
    public ListNode reverseList(ListNode head) {
        node = answer;
        dfs(head);
        return answer.next;
    }

    void dfs(ListNode target){
        if(target != null){
            dfs(target.next);
            this.node.next = target;
            this.node = target;
            this.node.next = null;
        }
    }
}