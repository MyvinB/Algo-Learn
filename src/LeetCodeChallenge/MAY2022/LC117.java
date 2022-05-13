package LeetCodeChallenge.MAY2022;


import TopicWise2022.Tree.common.Node;

import java.util.LinkedList;
import java.util.Queue;


public class LC117 {

        public Node connectUsingSpace(Node root) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                Node prev = null;
                while(size-->0){
                    Node cur = queue.poll();
                    if(cur.left!=null) queue.add(cur.left);
                    if(cur.right!=null) queue.add(cur.right);
                    if(prev!=null) prev.next = cur;
                    prev = cur;
                }
            }
            return root;
        }

        public Node connect(Node root){
            Node head = root;
            Node dummy = new Node(0);
            Node pre = dummy;
            while(root!=null){
                if(root.left!=null){
                    pre.next= root.left;
                    pre=pre.next;
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
