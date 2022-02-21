import org.w3c.dom.Node;
public class insertIntoaSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        //Your code
        //case1
        //no node
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        //case2
        //node can be inserted into circle
        Node prev = head;
        Node cur = head.next;
        boolean toInsert = false;

        do {
            if (insertVal >= prev.val && insertVal <= cur.val) {
                toInsert = true;
            } else if (prev.val > cur.val) {
                if (insertVal >= prev.val || insertVal <= cur.val) {
                    toInsert = true;
                }
            }
            if (toInsert) {
                prev.next = new Node(insertVal, cur);
                return head;
            }
            prev = cur;
            cur = cur.next;
        } while (prev != head);

        //case3
        //each node has same val in circle, it also can be inserted into circle
        prev.next = new Node(insertVal, cur);
        return head;
    }
}
