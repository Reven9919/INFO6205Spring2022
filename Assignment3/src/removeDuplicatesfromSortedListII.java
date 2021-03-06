public class removeDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(pre.next.val != cur.next.val){
                pre = pre.next;
                cur = cur.next;
            } else{
                while(cur != null && cur.next != null && pre.next.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
