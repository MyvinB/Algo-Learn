package LeetCode.Trees;/*
 @author Myvin Barboza
 23/06/20 6:07 PM 
 */

public class LC222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        helper(root);
        return count;
    }

    int count=0;
    public void helper(TreeNode root){
        if(root!=null)
            count++;
        else return;
        helper(root.left);
        helper(root.right);
    }
}
