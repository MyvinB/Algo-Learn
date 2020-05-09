package LeetCode.Trees;

/*
 @author Myvin Barboza
 09/05/20 7:49 AM 
 */
public class CousinsInBinaryTreeLC993 {

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



    public static void main(String[] args) {
    TreeNode n=new TreeNode(1);
    n.left=new TreeNode(2);
    n.right=new TreeNode(3);
    n.left.right=new TreeNode(4);
    n.right.right=new TreeNode(5);

        System.out.println(depth(n,4));
    }
}