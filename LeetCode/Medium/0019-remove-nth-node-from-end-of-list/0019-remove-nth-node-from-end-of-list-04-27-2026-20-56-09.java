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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            list.add(current);
            current = current.next;
        }
        ListNode node = list.get(list.size() - n);
        ListNode left = list.size() - n - 1 >= 0 ? list.get(list.size() - n - 1) : null;
        ListNode right = node.next;
        ListNode result = cutConnection(head, left, node, right);
        return result;
    }

    ListNode cutConnection(ListNode head, ListNode left, ListNode node, ListNode right){
        if(left != null && right != null){
            left.next = right;
            return head;
        }
        if(left != null){
            left.next = null;
            return head;
        }
        if(right!= null){
            return right;
        }
        return null;
    }
}