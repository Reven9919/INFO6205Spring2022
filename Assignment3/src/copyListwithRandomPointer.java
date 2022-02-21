import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class copyListwithRandomPointer {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(!cachedNode.containsKey(head)){
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random=copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
