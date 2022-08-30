package LeetCodeChallenge.Aug2022.GPRevision;



import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class LC138 {

    public static void main(String[] args) {

    }
        //Naive brutefiorce using space
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node n = head;
        while(n!=null){
            map.put(n,new Node(n.val));
            n = n.next;
        }
        n = head;
        while(n!=null){
            map.get(n).next  = map.get(n.next);
            map.get(n).random = map.get(n.random);
            n = n.next;
        }
        return map.get(head);
    }

    public Node copyRandomListOpt(Node head) {
        if(head == null) return null;
        Node n = head;
        //Storing the copy in the next pointer
        while(n!=null){
            Node next = n.next;
            n.next = new Node(n.val);
            n.next.next = next;
            n = next;
        }
        //Now accomodating the random pointers for copy
        n = head;
        while(n!=null){
            if(n.random!=null){
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }
        n = head;
        //Just destructuring stuff
        Node copyHead = n.next;
        Node copy = copyHead;
        while(copy.next!=null){
            n.next = n.next.next;
            n = n.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        n.next = null;
        return copyHead;
    }
}
