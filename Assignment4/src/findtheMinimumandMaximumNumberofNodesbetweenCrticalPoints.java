import java.util.ArrayList;
import java.util.List;

public class findtheMinimumandMaximumNumberofNodesbetweenCrticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode p = head;
        while(p != null){
            nums.add(p.val);
            p = p.next;
        }
        int n = nums.size();
        List<Integer> a = new ArrayList<>();
        for(int i = 1; i < n - 1; i++){
            if(nums.get(i - 1) > nums.get(i) && nums.get(i) < nums.get(i + 1)){
                a.add(i);
            }else if(nums.get(i - 1) < nums.get(i) && nums.get(i) > nums.get(i + 1)){
                a.add(i);
            }
        }
        int an = a.size();
        if(an < 2){
            return new int []{-1,-1};
        }
        int max_ = a.get(a.size() -1)- a.get(0);
        int min_ = Integer.MAX_VALUE;
        for(int i = 1; i < an; i++){
            min_ = Math.min(min_, a.get(i) - a.get(i - 1));
        }
        return new int []{min_, max_};
    }
}
