package Combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 27/04/20 11:05 AM 
 */public class PermutationsUsingArrayLC46 {

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        boolean check[]=new boolean[nums.length];

        dfs(nums,list,0,new Integer[nums.length],check);
        return list;
    }

    static void dfs(int[] nums,List<List<Integer>> list,int curIndex, Integer[] path,boolean check[]){
        if(curIndex==nums.length){
            list.add(Arrays.asList(Arrays.copyOf(path,curIndex)));
            return;
        }

        for (int i = 0; i <path.length ; i++) {
            if(!check[i]){
                //
                check[i]=true;

                path[i]=nums[curIndex];

                dfs(nums,list,curIndex+1,path,check);
                check[i]=false;

            }
        }
    }

    public static void main(String[] args) {
        int n[]={1,2,3};
        System.out.println(permute(n));
    }
}