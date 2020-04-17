package Trees;

/*
 @author Myvin Barboza
 16/04/20 3:11 PM 
 */public class SumRootToLeafNumbersLC129 {

    static int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return sumTree(root,0);
    }

    static int sumTree(TreeNode root,int sum){
        if(root!=null)
        sum=sum+root.val;
        if(root.left==null&& root.right==null) return sum;

        return (root.left!=null?sumTree(root.left,sum*10):0) + (root.right!=null?sumTree(root.right,sum*10):0);

    }




     public static void main(String[] args) {
    TreeNode t=new TreeNode(0);

    t.right=new TreeNode(1);
         System.out.println(sumNumbers(t));
    }
}