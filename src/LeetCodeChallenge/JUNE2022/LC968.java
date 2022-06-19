package LeetCodeChallenge.JUNE2022;

import TopicWise2022.Tree.common.TreeNode;
import com.sun.source.tree.BreakTree;

public class LC968 {

    public static void main(String[] args) {

    }
    /*
    *   Return 0 if it's a leaf.
        Return 1 if it's a parent of a leaf, with a camera on this node.
        Return 2 if it's coverd, without a camera on this node.
    * */
    int res = 0;
    public int minCameraCover(TreeNode root) {
        return dfs(root)<1?res+1:res;
    }

    public int dfs(TreeNode root){
        if(root==null) return 2;
        int left = dfs(root.left) ,right = dfs(root.right);
        if(left ==0 || right == 0){
            res++;
            return 1;
        }
        return left==1 || right==1?2:0;
    }
}
