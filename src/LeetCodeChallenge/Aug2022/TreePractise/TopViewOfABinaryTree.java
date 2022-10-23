package LeetCodeChallenge.Aug2022.TreePractise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class TopViewOfABinaryTree {

    public static void main(String[] args) {

    }

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static  class Pair {
        final BinaryTreeNode root;
        final int position;

        public Pair(BinaryTreeNode root, int position) {
            this.root = root;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "root=" + root +
                    ", position=" + position +
                    '}';
        }
    }
    //Using NLogN considering a skwed tree
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.peek().root;
            int vlevel = queue.poll().position;
            if(!map.containsKey(vlevel)) map.put(vlevel,node.val);
            if(node.left!=null) queue.add(new Pair(root.left,vlevel-1));
            if(node.right!=null) queue.add(new Pair(root.right,vlevel+1));
        }
        List<Integer> res = new ArrayList<>();
        for(int i:map.keySet()) res.add(map.get(i));
        return (ArrayList<Integer>) res;
    }
}
