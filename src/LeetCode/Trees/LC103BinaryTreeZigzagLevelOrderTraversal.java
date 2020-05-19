package LeetCode.Trees;
/*
 @author Myvin Barboza
 19/05/20 6:15 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC103BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        zigzagLevelOrder(root,0,list);
        return list;
    }

    static void zigzagLevelOrder(TreeNode root,int level,List<List<Integer>> list) {


        if(root==null) return;

        if(list.size()<=level){
            List<Integer> ilist=new ArrayList<>();
            list.add(ilist);
        }

        List<Integer> ilist=list.get(level);
        if(level%2==0) ilist.add(root.val);
        if(level%2!=0) ilist.add(0,root.val);
        zigzagLevelOrder(root.left,level+1,list);
        zigzagLevelOrder(root.right,level+1,list);

    }

    public static void main(String[] args) {

    }
}