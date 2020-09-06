package LeetCode.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC1305AllElementsinTwoBinarySearchTrees {
    public static void main(String[] args) {

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list=new ArrayList<>();
        dfs(root1,list);
        dfs(root2,list);
        Collections.sort(list);
        return list;
    }

    void dfs(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}

