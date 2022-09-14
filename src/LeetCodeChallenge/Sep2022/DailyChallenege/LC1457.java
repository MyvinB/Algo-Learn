package LeetCodeChallenge.Sep2022.DailyChallenege;

import TopicWise2022.Tree.common.TreeNode;

import java.util.Arrays;

public class LC1457 {

    public static void main(String[] args) {

    }

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] A = new int[10];
        int[] P = new int[1];
        dfs(root,A,P);
        return P[0];
    }

    public void dfs(TreeNode root, int[] A,int[] P){
        if(root==null) return;
        A[root.val]++;
        if(root.left==null && root.right==null){
            // System.out.println("Leaf node is "+ root.val);
            if(isPalindrome(A)) P[0]++;
        }
        //Move left
        dfs(root.left,A,P);
        dfs(root.right,A,P);
        A[root.val]--;
    }

    public boolean isPalindrome(int[] A){
        int count = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2!=0)
                count += A[i]%2;
        }
        // System.out.println(Arrays.toString(A));
        if(count==1|| count==0) return true;
        return  false;
    }
}
