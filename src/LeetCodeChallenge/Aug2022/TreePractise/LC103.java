package LeetCodeChallenge.Aug2022.TreePractise;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC103 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root,0,res);
        return res;
    }

    public void dfs(TreeNode root,int level,List<List<Integer>> list ){
        if(root==null) return;
        if(list.size()==level){
            List<Integer> temp = new ArrayList<>();
            list.add(temp);
        }
        List<Integer> temp = list.get(level);
        if(level%2==0) temp.add(root.val);
        else temp.add(0,root.val);

        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);

    }
}
