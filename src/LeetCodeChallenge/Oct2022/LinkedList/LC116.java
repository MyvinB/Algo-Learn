package LeetCodeChallenge.Oct2022.LinkedList;

import TopicWise2022.Tree.common.Node;

public class LC116 {

    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        Node levelStart = root;
        while(levelStart!=null){
            Node cur = levelStart;
            while(cur!=null){
                if(cur.left!=null) cur.left.next = cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }
}
