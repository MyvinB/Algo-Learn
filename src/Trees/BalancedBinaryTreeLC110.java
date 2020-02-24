package Trees;

/*
 * Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

 class BalanceStatusWithHeight {
	    public boolean isBalanced;
	    public int height;

	    public BalanceStatusWithHeight(boolean isBalanced, int height) {
	      this.isBalanced = isBalanced;
	      this.height = height;
	    }
	  } 

public class BalancedBinaryTreeLC110 {


	
	static boolean isBalanced(TreeNode val) {
	        return checkBalanced(val).isBalanced;
	 }
	//recursive call with an avl tree
	 private static BalanceStatusWithHeight checkBalanced(TreeNode val) {
		 if(val==null){
			 return new BalanceStatusWithHeight(true, -1);
		 }
		  BalanceStatusWithHeight leftResult = checkBalanced(val.left);
		  if (!leftResult.isBalanced) {
		      return leftResult; // Left subtree is not balanced. Bubble up failure.
		  }
		   BalanceStatusWithHeight rightResult = checkBalanced(val.right);
		   if (!rightResult.isBalanced) {
		      return rightResult; // Right subtree is not balanced. Bubble up failure.
		    }
		   boolean subtreesAreBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
		    int height = Math.max(leftResult.height, rightResult.height) + 1;
		    return new BalanceStatusWithHeight(subtreesAreBalanced, height);
	 }
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1); 
        tree.left = new TreeNode(2); 
        tree.right = new TreeNode(3); 
        tree.left.left = new TreeNode(4); 
        tree.left.right = new TreeNode(5); 
        tree.left.left.left = new TreeNode(8); 
       System.out.println(isBalanced(tree));
	}
}
