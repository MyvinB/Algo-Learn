package LeetCode.Trees;/*
 @author Myvin Barboza
 27/07/20 4:12 PM 
 */

public class LC538ConvertBSTtoGreaterTree {

    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
}
