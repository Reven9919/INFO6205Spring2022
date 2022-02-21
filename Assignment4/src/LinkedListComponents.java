import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsset = new HashSet();
        for(int x : nums) numsset.add(x);

        ListNode cur = head;
        int ans = 0;
        while(cur != null){
            if(numsset.contains(cur.val) &&(cur.next == null || !numsset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }
        return ans;
    }
}
