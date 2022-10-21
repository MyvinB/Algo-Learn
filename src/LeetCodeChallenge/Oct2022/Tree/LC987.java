package LeetCodeChallenge.Oct2022.Tree;

import TopicWise2022.Tree.common.TreeNode;

import java.util.*;

public class LC987 {

    public static void main(String[] args) {

    }

    HashMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new HashMap<>();
    int min = 0,max=0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,0);
        for(int i=min;i<=max;i++){
            List<Integer> temp = new ArrayList<>();
            for(int k: map.get(i).keySet()){
                    PriorityQueue<Integer> pq = map.get(i).get(k);
                    while(!pq.isEmpty()) temp.add(pq.poll());
            };
            res.add(new ArrayList<>(temp));
        }
        return res;
    }


    public void dfs(TreeNode root,int vL,int hL){
        if(root==null) return;
        min = Math.min(min,vL);
        max = Math.max(max,vL);
        if(!map.containsKey(vL)){
            map.put(vL,new TreeMap<>());
        }
        if(!map.get(vL).containsKey(hL)){
            map.get(vL).put(hL,new PriorityQueue<>());
        }
        map.get(vL).get(hL).offer(root.val);
        dfs(root.left,vL-1,hL+1);
        dfs(root.right,vL+1,hL+1);
    }
}
