package LeetCodeChallenge.Sep2022.DailyChallenege;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC987VerticalOrderOfBinaryTree {

    public static void main(String[] args) {

    }
    int min=0,max=0;
    HashMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=min;i<=max;i++){
            TreeMap<Integer,PriorityQueue<Integer>> trMap = map.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int k:trMap.keySet()){
                PriorityQueue<Integer> pq = trMap.get(k);
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

    public void dfs(TreeNode root,int vLevel,int hLevel){
        if(root==null) return;
        min = Math.min(vLevel,min);
        max = Math.max(vLevel,max);
        if(!map.containsKey(vLevel)){
            map.put(vLevel,new TreeMap<>());
        }
        if(!map.get(vLevel).containsKey(hLevel)){
            map.get(vLevel).put(hLevel,new PriorityQueue<Integer>());
        }
        map.get(vLevel).get(hLevel).offer(root.val);
        dfs(root.left,vLevel-1,hLevel+1);
        dfs(root.right,vLevel+1,hLevel+1);
    }
}
