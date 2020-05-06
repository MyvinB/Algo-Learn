package Trees;

/*
 @author Myvin Barboza
 29/04/20 4:27 PM 
 */public class BinaryTreeMaximumPathSumLC124 {
    static int result = Integer.MIN_VALUE;
    static int maxPathSum(TreeNode root)
    {
        findMax(root);
        return result;
    }


    static int findMax(TreeNode root)
    {
        if(root==null) return 0;

        int left=Math.max(findMax(root.left),0);
        int right=Math.max(findMax(root.right),0);

        result=Math.max(result,root.val+left+right);

        return root.val+Math.max(left,right);

    }



    public static void main(String[] args) {
        TreeNode n=new TreeNode(1);
        n.left=new TreeNode(2);
        n.right=new TreeNode(3);
        n.left.left=new TreeNode(4);
        n.left.right=new TreeNode(5);
        System.out.println(maxPathSum(n));
    }
}