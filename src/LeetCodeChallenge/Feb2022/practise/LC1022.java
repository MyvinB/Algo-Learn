package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 3:43 PM 2/14/2022
 * Time Taken:
 */
public class LC1022 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int val){
        if(root==null)return 0;
        val =val*2+root.val;
        return root.left==root.right?val: dfs(root.left,val)+dfs(root.right,val);
    }
}
