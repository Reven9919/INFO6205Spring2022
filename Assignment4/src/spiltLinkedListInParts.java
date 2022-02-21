public class spiltLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt = 0;
        ListNode tmp = head;
        while(tmp != null && ++cnt > 0) tmp = tmp.next;
        int per = cnt / k;
        ListNode[] ans = new ListNode[k];
        for(int i = 0, sum = 1; i < k; i++, sum++){
            ans[i] = head;
            tmp = ans[i];
            int u = per;
            while(u-- > 1 && ++sum >0) tmp = tmp.next;
            int remain = k - i -1;
            if(per != 0 && sum + per * remain < cnt && ++sum > 0) tmp = tmp.next;
            head = tmp != null? tmp.next : null;
            if(tmp != null) tmp.next = null;
        }
        return ans;
    }
}
