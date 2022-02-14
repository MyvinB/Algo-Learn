package LeetCodeChallenge.Feb2022.practise;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 11:27 AM 2/14/2022
 * Time Taken:
 */
public class LC589 {

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

    public List<Integer> preorderIterative(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            List<Node> list = temp.children;
            res.add(temp.val);
            for(int i=list.size()-1;i>=0;i--){
                stack.add(list.get(i));
            }
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null) return res;
        res.add(root.val);
        for(Node t : root.children){
            preorder(t);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
