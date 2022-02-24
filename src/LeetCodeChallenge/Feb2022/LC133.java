package LeetCodeChallenge.Feb2022;

import org.w3c.dom.Node;

import java.util.*;

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



    public Node cloneGraph(Node node){
        HashMap<Node,Node> map = new HashMap<>();
        return dfs(node,map);
    }
    //DFS
    public Node dfs(Node node,HashMap<Node,Node> map){
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node,copy);

        for(Node child:node.neighbors){
            copy.neighbors.add(dfs(child,map));
        }
        return copy;
    }

    //BFS APPROACH
    public Node cloneGraphBFS(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node,newNode);
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node originalNode  = queue.poll();
                for(Node child:originalNode.neighbors){
                    if(!map.containsKey(child)){
                        Node newChild = new Node();
                        newChild.val = child.val;
                        map.put(child,newChild);
                        queue.offer(child);
                    }
                    Node orginalNodeCopy = map.get(originalNode);
                    orginalNodeCopy.neighbors.add(map.get(child));
                }
            }

        }
        return map.get(node);
    }
}
