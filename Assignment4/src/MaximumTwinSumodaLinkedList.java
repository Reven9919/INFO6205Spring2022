import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumodaLinkedList {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int ans = 0;
        for(int i = 0; i < list.size() / 2; i++){
            ans = Math.max(ans, list.get(i) + list.get(list.size() - i - 1));
        }
        return ans;
    }
}
