package practise;

public class LC993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(depth(root,x)==depth(root,y) && parents(root,x)!=parents(root,y)) return true;
        return false;
    }

    public static TreeNode parents(TreeNode root,int data){
        if(root==null) return null;
        if(root.left!=null && root.left.val==data) return root;
        if(root.right!=null && root.right.val==data) return root;

        TreeNode left=parents(root.left,data);
        if(left!=null) return left;
        return parents(root.right,data);

    }

    public static int depth(TreeNode root,int data){

        if(root==null) return Integer.MIN_VALUE;
        if(root.val==data) return 0;

        return 1+Math.max(depth(root.left,data),depth(root.right,data));
    }
}
