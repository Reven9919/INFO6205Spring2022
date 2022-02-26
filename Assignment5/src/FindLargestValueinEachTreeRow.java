import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if(null != poll && poll.val > max){
                    max = poll.val;
                }
                if(null != poll.left){
                    queue.offer(poll.left);
                }
                if(null != poll.right){
                    queue.offer(poll.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
