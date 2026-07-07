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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /**
        - p1: pointer of list1
        - p2: pointer of list2
        - curr: tail of the answer list node

        1) pick the smaller node of list1 of list2
        2) we set curr.next to smaller node
        3) move p1 or p2 forward
        4) set curr to curr.next
        5) repeat this process until p1 and p2 become null
         */

        ListNode curr = new ListNode();
        ListNode ans = curr;
        ListNode p1 = list1, p2 = list2;

        while(p1 != null || p2 != null) {
            int v1 = p1 == null ? 101 : p1.val;
            int v2 = p2 == null ? 101 : p2.val;
            if(v1 < v2) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }

         return ans.next;
    }
}