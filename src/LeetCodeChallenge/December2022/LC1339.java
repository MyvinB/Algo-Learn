package LeetCodeChallenge.December2022;

import TopicWise2022.Tree.common.TreeNode;

public class LC1339 {

    public static void main(String[] args) {

    }
    long total=0,max=0,sum;
    public int maxProduct(TreeNode root) {
        int mod = (int)1e9+7;
        total = dfs(root);dfs(root);
        return (int)(max%mod);
    }

    public long dfs(TreeNode root){
        if(root==null) return 0;
        sum = root.val+dfs(root.left)+dfs(root.right);
        max = Math.max(max,sum*(total-sum));
        return sum;
    }
}
