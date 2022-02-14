package LeetCodeChallenge.Feb2022.practise;

/**
 * @author mmichaelbarboza
 * on 8:22 PM 2/13/2022
 * Time Taken:
 */
public class LC235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else return root;
    }

   

}
