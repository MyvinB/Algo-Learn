package LeetCode.Trees;/*
 @author Myvin Barboza
 29/07/20 11:36 AM 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC508MostFrequentSubtreeSum {
    int maxCount=Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map=new HashMap<>();
        dfs(root,map);
        List<Integer> list=new ArrayList<>();
        for(int i:map.keySet()){
            if(map.get(i)==maxCount){
                list.add(i);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    int dfs(TreeNode root,HashMap<Integer,Integer> map){
        int sum=0;
        if(root==null) return 0;
        if(root!=null){
            sum+=root.val;
            if(root.right!=null)
                sum+=dfs(root.right,map);;
            if(root.left!=null)
                sum+=dfs(root.left,map);;
        }
        int count=map.getOrDefault(sum,0)+1;
        maxCount=Math.max(count,maxCount);
        map.put(sum,count);
        return sum;
    }
    public static void main(String[] args) {

    }
}
