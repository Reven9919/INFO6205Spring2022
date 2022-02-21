import java.util.ArrayList;
import java.util.List;

public class nextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size() - 1; i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(j) > list.get(i)){
                    res[i] = list.get(j);
                    break;
                }
            }
        }
        return res;
    }
}
