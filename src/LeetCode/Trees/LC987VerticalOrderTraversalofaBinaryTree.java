package LeetCode.Trees;/*
 @author Myvin Barboza
 08/08/20 9:29 AM 
 */

import Challenge.A;

import java.util.*;
import java.util.function.Consumer;

public class LC987VerticalOrderTraversalofaBinaryTree {
    public static void main(String[] args) {

    }
    //we don not require a priority que as use a list we have to pop all elemnts out so nlong time only
    //instead of using log n time sorting all the time obviously time is the same but I thought this would  be better
    //using a one time sort


      class Info{
        int x;
        int y;
        int val;


        Info(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,List<Info>> map=new HashMap<>();
        List<List<Integer>> list=new ArrayList<>();
        dfs(root,map,0,0);
        for(int i=min;i<=max;i++){
            List<Info> infoList=map.get(i);
            Collections.sort(infoList,(a,b)->a.y==b.y?a.val-b.val:a.y-b.y);
            List<Integer> temp=new ArrayList<>();
            for(Info info:infoList){
                temp.add(info.val);
            }
            list.add(temp);
        }
        return list;
    }

    void dfs(TreeNode root,HashMap<Integer,List<Info>> map,int x, int y){
        if(root==null) return;
       List<Info> list=map.getOrDefault(x,new ArrayList<Info>());
       Info obj=new Info(x,y,root.val);
       min=Math.min(min,x);
       max=Math.max(max,x);
       list.add(obj);
       map.put(x,list);
       dfs(root.left,map,x-1,y+1);
       dfs(root.right,map,x+1,y+1);
    }

}
