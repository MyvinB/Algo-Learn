package LeetCodeChallenge.Oct2022.LinkedList;



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

    public Node copyRandomList(Node head) {
        if(head ==null) return head;
        //Populate next pointer with the copy
        Node n = head;
        //Storing the copy in the next pointer
        while(n!=null) {
            Node next = n.next;
            n.next = new Node(n.val);
            n.next.next = next;
            n = n.next.next;
        }
        // //Now accomodating the random pointers for copy
        n = head;
        while(n!=null){
            if(n.random!=null){
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }
        //Deconstructing both the list
        n = head;
        Node copy = n.next;
        Node copyHead = copy;
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
