package practise;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 9:56 PM 11/23/2021
 */
public class LC952 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(largestComponentSize(nums));
    }
    static class Node{
        int val;
        int rank;
        Node parent;
    }
    static HashMap<Integer,Node>  map = new HashMap<>();
    public static void makeSet(int data){
        Node node = new Node();
        node.val = data;
        node.rank = 1;
        node.parent = node;
        map.put(data,node);
    }
    //Path compression
    public static Node findSet(Node node){
        Node parent = node.parent;
        if(parent==node) return parent;
        node.parent = findSet(node.parent);
        return node.parent;
    }
    
    public static boolean union(int data1, int data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        Node p1 = findSet(node1);
        Node p2 = findSet(node2);
        if(p1==p2) return false;
        if(p1.rank>= p2.rank){
            p1.rank = p2.rank==p1.rank?p1.rank+1:p2.rank;
            p2.parent = p1;
        }
        else p1.parent = p2;
        return true;

    }

    public static int largestComponentSize(int[] nums) {

        for(int i :nums){
            for(int j=2;j*j<=i;j++){
                if(i%j ==0){
                    if(!map.containsKey(i)){
                        makeSet(i);
                    }
                    if(!map.containsKey(j)){
                        makeSet(j);
                    }
                    if(!map.containsKey(i/j)){
                        makeSet(i/j);
                    }
                    union(i,j);
                    union(i,i/j);
                }
            }
        }

        HashMap<Integer,Integer> mapToFind = new HashMap<>();
        int max=1;
        for(int i:nums) {
            if(map.containsKey(i)){
                Node node = map.get(i);
                Node parent = findSet(node) ;
                mapToFind.put(parent.val,mapToFind.getOrDefault(parent.val,0)+1);
                max= Math.max(max,mapToFind.get(parent.val));
            }

        }
        return max;
    }

}
