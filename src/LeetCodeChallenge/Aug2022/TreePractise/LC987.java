package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC987 {

    public static void main(String[] args) {

    }
    HashMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>();
    int min, max = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        System.out.println(map);
        for(int i=min;i<=max;i++){
            List<Integer> temp = new ArrayList<>();
            TreeMap<Integer,PriorityQueue<Integer>> hMap = map.get(i);
            System.out.println(hMap);
            for(int k:hMap.keySet()){
                while(!hMap.get(k).isEmpty()){
                    temp.add(hMap.get(k).poll());
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
    //Have the image in your mind vlevel min max tells us how to iterate internally use a treeMap as we do not know the index it will be in a lookup will take time so treeMap and pq for same place sorting.
    public void dfs(TreeNode root,int vlevel,int hlevel){
        if(root!=null){
            min = Math.min(vlevel,min);
            max = Math.max(vlevel,max);
            if(!map.containsKey(vlevel)){
                map.put(vlevel,new TreeMap<>());
            }
            if(!map.get(vlevel).containsKey(hlevel)){
                map.get(vlevel).put(hlevel,new PriorityQueue<>());
            }
            map.get(vlevel).get(hlevel).offer(root.val);
            dfs(root.left,vlevel-1,hlevel+1);
            dfs(root.right,vlevel+1,hlevel+1);
        }
    }
}
