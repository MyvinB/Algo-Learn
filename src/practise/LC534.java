package practise;

public class LC534 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    int findMax(TreeNode root){
        if(root == null) return 0;

        int left = findMax(root.left);
        int right = findMax(root.right);
        //whole tree including root node at every level
        max = Math.max(max,left+right);
        //think height of tree;
        return 1 + Math.max(left,right);
    }
}
