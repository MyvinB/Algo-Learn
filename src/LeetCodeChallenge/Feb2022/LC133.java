package LeetCodeChallenge.Feb2022;

import org.w3c.dom.Node;

/**
 * @author mmichaelbarboza
 * on 5:50 AM 2/24/2022
 * Time Taken:
 */
public class LC133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {

    }
}
