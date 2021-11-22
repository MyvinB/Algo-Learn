package practise;

import Challenge.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfIslands2 {

    public static void main(String[] args) {
    NumberOfIslands2 trial = new NumberOfIslands2();
//    for(int i=1;i<=7;i++){
//        trial.makeSet(i);
//    }
//    trial.union(1,2);
//    trial.union(2,3);
//    trial.union(4,5);
//    trial.union(6,7);
//    trial.union(5,6);
//    trial.union(3,7);
//
//
//
//    for(int i=1;i<=7;i++){
//        System.out.println(trial.findSet(i));
//    }

        //2
        //2
        //[[0,0],[1,1],[1,0],[0,1]] ans
        System.out.println(trial.numOfIslands2(2,2,new int[][]{{0,0},{1,1},{1,0},{0,1}}));

    }

    public List<Integer> numOfIslands2(int m,int n,int[][] positions){
        boolean[] isLand = new boolean[m*n];
        int count = 0;
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                makeSet(i*n+j);
            }
        }
        for(int[] p :positions){
            int index =p[0]*n+p[1];
            if(isLand[index]){
                res.add(count);
                continue;
            }
            isLand[index]= true;
            count++;
            for(int[] d:dir){
                int x = p[0]+d[0];
                int y = p[1]+d[1];
                int newIndex = x*n+y;
                if(x<0 || x>=m || y<0 || y>=n || !isLand[newIndex])continue;
                if(union(index,newIndex)){
                    count--;
                }
                };

            res.add(count);

        }
        return res;
    }

    static class Node{
        int data;
        int rank;
        Node parent;
    }
    HashMap<Integer,Node> map = new HashMap<>();
    public void makeSet(int data){
        Node node = new Node();
        node.parent = node;
        node.data = data;
        node.rank = 1;
        map.put(data,node);
    }

    public Node findSet(Node node){
        Node parent = node.parent;
        if(node==parent){
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    /**
     * Finds the representative of this set
     */
    public int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    public boolean union(int data1, int data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);
        //they are already in the same set if they both have the same parents
        if(parent1==parent2) return false;
        if(parent1.rank>=parent2.rank){
            parent1.rank = parent1.rank == parent2.rank? parent1.rank+1:parent1.rank;
            parent2.parent= parent1;
        }
        else parent1.parent= parent2;
        return true;
    }


}
