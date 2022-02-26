import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class findLeavesofBinaryTree {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root ==  null){
            return res;
        }
        while(root.left != null || root.right != null){
            helper(root, null, list);
            res.add(new ArrayList<>(list));
            list.clear();
        }
        list.add(root.val);
        res.add(new ArrayList<>(list));
        return res;
    }

    private void helper(TreeNode root, TreeNode pre, List<Integer> list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            if(pre != null && pre.left == root) pre.left = null;
            if(pre != null && pre.right == root)pre.right = null;
        }
        pre = root;
        helper(root.left, pre, list);
        helper(root.right, pre, list);
    }
}
