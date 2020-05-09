package LeetCode.Combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 27/04/20 9:41 AM 
 */public class PermutationsUsingListLC46 {


    static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        boolean check[]=new boolean[nums.length];
        dfs(nums,list,new ArrayList<>(),check);
        return list;
    }

    static void dfs(int[] nums,List<List<Integer>> list, List<Integer> path,boolean check[]){
        if(path.size()==nums.length){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {

            if(!check[i]){

                //permuation 2 check for false also sort the array
                if(i>0 && nums[i]==nums[i-1] && !check[i-1]) continue;
                check[i]=true;
                path.add(nums[i]);
                dfs(nums,list,path,check);

                path.remove(path.size()-1);
                check[i]=false;
            }
        }
    }


     public static void main(String[] args) {
        int n[]={1,2,3};
         System.out.println(permute(n));
    }
}