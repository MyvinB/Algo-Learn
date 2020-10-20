package LeetCode.Graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

public class LC133CloneGraph {
    static private HashMap<Integer,Node> map=new HashMap<>();

    static Node cloneGraph(Node node) {
        if(node==null)
            return null;
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node clone =new Node(node.val,new ArrayList<>());
        map.put(node.val,clone);
        for(Node neighbour : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbour));
        }
        return clone;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors = Arrays.asList(two,four);
        two.neighbors = Arrays.asList(three,four);
        three.neighbors = Arrays.asList(two,four);
        four.neighbors = Arrays.asList(one,three);
        Node clone= cloneGraph(one);
    }
}
