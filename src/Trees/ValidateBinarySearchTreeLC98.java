package Trees;

/*
 @author Myvin Barboza
 26/04/20 12:13 PM 
 */public class ValidateBinarySearchTreeLC98 {

    static boolean isValidBST(TreeNode root) {

        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValidBST(TreeNode root,long min_val,long maxval){
        if(root==null) return true;
        if(root.val>=maxval || root.val<=min_val) return false;
        else return isValidBST(root.left,min_val,root.val) && isValidBST(root.right,root.val,maxval);
    }

     public static void main(String[] args) {

    }
}