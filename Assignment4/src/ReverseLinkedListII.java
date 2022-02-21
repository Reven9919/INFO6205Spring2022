public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        for(int step = 0; step < left - 1; step++){
            g = g.next;
            p = p.next;
        }
        for(int i = 0; i < right - left; i++){
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
}
