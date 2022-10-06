package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.Tree.common.Node;

public class LC117 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        Node head = root;
        Node dummy = new Node(-1);
        Node pre = dummy;
        while(root!=null){
            if(root.left!=null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right!=null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root==null){
                pre = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return head;
    }
}
