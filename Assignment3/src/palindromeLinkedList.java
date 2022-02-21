import java.util.ArrayList;
import java.util.List;

public class palindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur != null){
            vals.add(cur.val);
            cur = cur.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while(front < back){
            if(!vals.get(front).equals(vals.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
