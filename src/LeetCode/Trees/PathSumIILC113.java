package LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

/*
 @author Myvin Barboza
 22/04/20 4:02 PM 
 */public class PathSumIILC113 {

    static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list=new ArrayList<>();
        pathSum(root,sum,list,new ArrayList<>());
        return list;
    }

    static void pathSum(TreeNode root,int sum,List<List<Integer>> list, List<Integer> temp){
        if(root==null) return;
        temp.add(root.val);
        if(root.left==null && root.right==null && sum-root.val==0) {
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }else{
            pathSum(root.left,sum-root.val,list,temp);
            pathSum(root.right,sum-root.val,list,temp);

        }


            temp.remove(temp.size()-1);

    }


     public static void main(String[] args) {
        TreeNode t=new TreeNode(5);
        t.left=new TreeNode(4);
        t.right=new TreeNode(8);
        t.left.left=new TreeNode(11);
        t.right.right=new TreeNode(4);
        t.right.left=new TreeNode(13);
         t.left.left.left=new TreeNode(7);
         t.left.left.right=new TreeNode(2);
         t.right.right.right=new TreeNode(1);
         t.right.right.left=new TreeNode(5);
         System.out.println(pathSum(t,22));
    }
}