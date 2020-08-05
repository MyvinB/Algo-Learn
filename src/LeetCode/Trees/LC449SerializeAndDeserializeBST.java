package LeetCode.Trees;/*
 @author Myvin Barboza
 05/08/20 9:34 AM 
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC449SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        return serialize(root,sb);
    }

    public String serialize(TreeNode root, StringBuilder sb){
        if(root==null) return "";
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> queue=new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode deserialize(Queue<String> queue, int lower, int higher){
        if(queue.isEmpty()) return null;
        int val=Integer.parseInt(queue.peek());
        if(val<lower || val>higher ) return null;
        queue.poll();

        TreeNode root=new TreeNode(val);
        root.left=deserialize(queue,lower,val);
        root.right=deserialize(queue,val,higher);
        return root;
    }

}
