package LeetCode.Trees;/*
 @author Myvin Barboza
 20/07/20 12:15 PM 
 */


import java.util.LinkedList;
import java.util.Queue;

public class LC116PopulatingNextRightPointersinEachNode {


        //okay but specifically said constant space men
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node cur=queue.poll();
                if(i!=size-1)cur.next=queue.peek();
                if(cur.left!=null)queue.offer(cur.left);
                if(cur.right!=null)queue.offer(cur.right);


            }
        }
        return root;
    }

    public Node connectN(Node root) {
        // if(root==null) return;
        //left most node of each level
        Node curLevel=root;
        while(curLevel!=null){
            //setting of next pointer of  node in one level below
            Node cur=curLevel;
            while(cur!=null){
                if(cur.left!=null)cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                cur=cur.next;
            }
            curLevel=curLevel.left;
        }
        return root;

    }

    public static void main(String[] args) {

    }

}
