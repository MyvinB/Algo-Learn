package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 8:35 PM 2/13/2022
 * Time Taken:
 */
public class GFGDistanceBtwnTwoNodesInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public int lowestCommonAncestor(LC235.TreeNode root, LC235.TreeNode p, LC235.TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else return dfs(root,p.val) + dfs(root, q.val);
    }

    public int dfs(LC235.TreeNode root, int target){
        if(root.val==target) return 0;
        if(root.val>target) return 1+dfs(root.left,target);
        else return 1 + dfs(root.right,target);
    }
}
