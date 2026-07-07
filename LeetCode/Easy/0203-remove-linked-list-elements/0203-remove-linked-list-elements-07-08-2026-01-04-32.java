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
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode();
        ListNode ans = h;

        ListNode curr = head;
        while(curr != null){
            System.out.println(curr.val);
            if(curr.val != val){
                h.next = curr;
                h = h.next;
            } else {
                h.next = null;
            }
            curr = curr.next;
        }

        return ans.next;
    }
}