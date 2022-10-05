package LeetCodeChallenge.Oct2022.Tree;


import TopicWise2022.Tree.common.TreeNode;

public class LC114 {

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode next = cur.left;
                while(next.right!=null)next = next.right;
                next.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
