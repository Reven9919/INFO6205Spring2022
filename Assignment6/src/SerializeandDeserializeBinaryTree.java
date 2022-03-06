import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X,";
        String leftSerialize = serialize(root.left); //左子树的序列化字符串
        String rightSerialize = serialize(root.right); //右子树的序列化字符串
        return root.val + "," + leftSerialize + rightSerialize;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        Deque<String> dp = new LinkedList<>(Arrays.asList(temp));
        return buildTree(dp);
    }
    private TreeNode buildTree(Deque<String> dq){
        String s = dq.poll();
        if (s.equals("X")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = buildTree(dq);
        node.right = buildTree(dq);
        return node;
    }
}
