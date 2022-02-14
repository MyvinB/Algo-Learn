    package LeetCodeChallenge.Feb2022.practise;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Stack;

    /**
     * @author mmichaelbarboza
     * on 10:24 AM 2/14/2022
     * Time Taken: 35 min
     */
    public class LC590 {

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
        //Iterative-> need to do better got confused
        public List<Integer> postorderIterative(Node root) {
            List<Integer> res = new ArrayList<>();
            if(root==null) return res;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty() ){
                Node temp = stack.pop();
                res.add(temp.val);
                List<Node> list = temp.children;
                for(int i= 0;i<list.size();i++){
                    stack.push(list.get(i));
                }
            }
            Collections.reverse(res);
            return res;
        }
        List<Integer> res = new ArrayList<>();
        public List<Integer> postorder(Node root) {
            if(root==null) return res;

            for(Node node:root.children){
                postorder(node);
            }

            res.add(root.val);
            return res;
        }
    }
