package LeetCode.Trees;

/*
 @author Myvin Barboza
 25/04/20 11:30 AM 
 */public class SearchInABinarySearchTreeLC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(val>root.val){
            return searchBST(root.right,val);
        }
        else if(val<root.val){
            return searchBST(root.left,val);
        }
        else{
            return root;
        }
    }
}