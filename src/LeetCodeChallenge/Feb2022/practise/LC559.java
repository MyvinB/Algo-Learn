package LeetCodeChallenge.Feb2022.practise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 4:15 PM 2/14/2022
 * Time Taken:
 */
public class LC559 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {

    }

    public int maxDepthIterative(Node root) {
        int count=0;
        if(root==null) return count;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                Node t = q.poll();
                for(Node n:t.children){
                    q.add(n);
                }
            }
        }
        return count;
    }

    public int maxDepth(Node root) {
        if(root==null) return 0;
        if(root.children==null) return 1;
        int max =0;
        for(Node t:root.children){
            max = Math.max(max,maxDepth(t));
        }
        return max+1;
    }
}
