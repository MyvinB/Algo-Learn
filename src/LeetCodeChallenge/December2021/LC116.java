package LeetCodeChallenge.December2021;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 3:38 PM 12/29/2021
 */
public class LC116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            while(size-->0){
                Node temp = que.poll();
                if(size==0){
                    temp.next = null;
                }else{
                    temp.next = que.peek();
                }

                if(temp.left!=null) que.add(temp.left);
                if(temp.right!=null)que.add(temp.right);
            }
        }
       return root;
    }

    public Node connectOptimised(Node root) {
        Node levelStart = root;
        while(levelStart!=null) {
            Node cur = levelStart;
            while (cur != null) {
                if (cur.left != null) cur.left.next = cur.right;
                if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }
}
