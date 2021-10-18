package practise;

import java.util.HashMap;

public class LC437 {
//    Simple DFS
    int ans=0;
//    public int pathSum(TreeNode root, int targetSum) {
//        if(root==null) return 0;
//        helper(root,targetSum);
//        pathSum(root.left,targetSum);
//        pathSum(root.right,targetSum);
//        return ans;
//    }
//
//    public void helper(TreeNode root,int targetSum){
//        if(root==null)return;
//        if(root.val==targetSum) ans++;
//        targetSum=targetSum-root.val;
//        helper(root.left,targetSum);
//        helper(root.right,targetSum);
//    }
    //Using prefix sum technique

    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        dfs(root,sum,map,0);
        return ans;
    }
    //rs running sum
    public void dfs(TreeNode root, Integer target, HashMap<Integer,Integer> map, Integer rs){
        if(root==null) return;
        rs+=root.val;
        ans=map.getOrDefault(rs-target,0);
        map.put(rs,map.getOrDefault(rs,0)+1);
        dfs(root.left,target,map,rs);
        dfs(root.right,target,map,rs);
    }
}
