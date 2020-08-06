package LeetCode.Trees;/*
 @author Myvin Barboza
 06/08/20 4:03 PM 
 */

public class LC235LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //val
        //can be used instead of break   (root.val - p.val) * (root.val - q.val) > 0
        //INtituion
        /*   Just walk down from the whole tree's root as long as both p and q are in the same subtree (meaning their values are both smaller or both larger than root's). This walks straight from the root to the LCA, not looking at the rest of the tree, so it's pretty much as fast as it gets. A few ways to do it:
         */

        while(true){
            int val=root.val;
            //left side
            if(val-p.val >0 && val-q.val>0) root=root.left;
                //right side
            else if(val-p.val<0 && val-q.val<0)root=root.right;
            else break;
        }
        return root;

    }

}
