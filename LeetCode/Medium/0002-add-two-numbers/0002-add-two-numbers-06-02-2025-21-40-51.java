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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode cur = answer;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        int carry = 0;
        while (tmp1 != null || tmp2 != null) {
            int num1 = tmp1 == null ? 0 : tmp1.val;
            int num2 = tmp2 == null ? 0 : tmp2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (tmp1 != null) tmp1 = tmp1.next;
            if (tmp2 != null) tmp2 = tmp2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return answer.next;
    }
}