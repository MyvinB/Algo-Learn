package LeetCodeChallenge.July2022;

import TopicWise2022.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC199 {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res,0,root);
        return res;
    }

    public void dfs(List<Integer> res,int curDepth,TreeNode root){
        if(root==null) return;
        if(curDepth ==res.size()){
            res.add(root.val);
        }
        dfs(res,curDepth+1,root.right);
        dfs(res,curDepth+1,root.left);
    }
}
