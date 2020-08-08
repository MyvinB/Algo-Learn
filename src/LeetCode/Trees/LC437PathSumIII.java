package LeetCode.Trees;/*
 @author Myvin Barboza
 08/08/20 4:47 PM 
 */

import java.util.HashMap;

public class LC437PathSumIII {
    public static void main(String[] args) {

    }

    int count=0;
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        dfs(root,sum,map,0);
        return count;

    }

    void dfs(TreeNode root,int k,HashMap<Integer,Integer> map,int sum){
        if(root==null) return;
        sum+=root.val;
        if(map.containsKey(sum-k)){
            count+=map.get(sum-k);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        dfs(root.left,k,map,sum);
        dfs(root.right,k,map,sum);
        map.put(sum,map.get(sum)-1);
    }

}
