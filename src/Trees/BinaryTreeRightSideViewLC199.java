package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 @author Myvin Barboza
 17/04/20 12:48 PM 
 */public class BinaryTreeRightSideViewLC199 {
    static List<Integer> rightSideView(TreeNode root) {
        List<Integer> t=new ArrayList<Integer>();
//        rightRecur(root,t,0);
//        return t;
        if(root==null) return null;

        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int size=que.size();
            for (int i = 0; i <size ; i++) {
                TreeNode n=que.poll();
                if(i==size-1){
                    t.add(n.val);
                }
                if(n.left!=null) que.add(n.left);
                if(n.right!=null) que.add(n.right);

            }
        }
        return t;

    }

    static void rightRecur(TreeNode curr,List<Integer> list,int currDepth) {
    if(curr==null) return;
    if(currDepth==list.size()){
        list.add(curr.val);
    }
    rightRecur(curr.right,list,currDepth+1);
    rightRecur(curr.left,list,currDepth+1);

    }



    public static void main(String[] args) {
    TreeNode t=new TreeNode(1);

        System.out.println(rightSideView(t));
    }
}