public class reverseNodeInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode p = head;
        int flag = 0;

        for(int j = 1; flag == 0; j++){
            int count = 0;
            ListNode reverse_head = prehead;
            ListNode reverse_tail = null;
            while(p != null && count <j){
                reverse_tail = p;
                prehead = prehead.next;
                p = p.next;
                count++;
                if(p == null){
                    flag = 1;
                }
            }
            if(count %2 == 0){
                prehead = reverse(reverse_head,reverse_tail);
            }
        }
        return head;
    }
    public ListNode reverse(ListNode prehead,ListNode tail){
        ListNode head = prehead.next;
        ListNode temp = head;
        while(temp != tail){
            ListNode cur = temp;
            temp = temp.next;
            cur.next = tail.next;
            tail.next = cur;
        }
        prehead.next = tail;
        return head;
    }
}
