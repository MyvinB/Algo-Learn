package Contest.LeetCode;

import TopicWise2022.Tree.common.TreeNode;

public class VContest8thMay {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("42352338"));
    }

    public static String largestGoodInteger(String num) {
        int max = Integer.MIN_VALUE;
        String maxi = "";
        int n = num.length();
        for(int i=1;i<n-1;i++){
            int cur = num.charAt(i);
            if(num.charAt(i-1) == cur &&  num.charAt(i+1)== cur){
                int p = Integer.parseInt(num.substring(i-1,i+2));
                if(p>max){
                    max = p;
                    maxi = num.substring(i-1,i+2);
                }
            }
        }
           return maxi;
    }


    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int left[] = dfs(root.left);
        int right[] = dfs(root.right);

        int curSum = left[0]+right[0]+root.val;
        int count = left[1]+right[1]+1;

        if(curSum/count==root.val) res++;

        return new int[]{curSum,count};
    }


//    public int countTexts(String pressedKeys) {
//        String[] s = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//        for(int i=0;i<pressedKeys.length();i++){
//
//        }
//    }
}
