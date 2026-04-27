class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 더미 노드 생성 (헤드 삭제 케이스 대응)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 2. fast를 n만큼 먼저 이동
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 3. fast가 끝에 도달할 때까지 두 포인터를 함께 이동
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 4. 노드 삭제 (연결 끊기)
        slow.next = slow.next.next;

        return dummy.next;
    }
}