package LeetCode.Combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 27/04/20 8:15 AM 
 */public class CombinationSumLC39 {


    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
    List<List<Integer>> list=new ArrayList<>();
    dfsTWO(candidates,target,0,list,new ArrayList<>());
    return list;
    }

//for combination sum 1
    static void dfs(int[] candidates,int target,int idx,List<List<Integer>> list,List<Integer> path){
        if(target==0){
            list.add(new ArrayList<>(path));
        }

        for (int i = idx; i <candidates.length ; i++) {
            if(candidates[i]>target)
                return;


            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],i,list,path);
            path.remove(path.size()-1);
        }
    }
///for combination sum2
    static void dfsTWO(int[] candidates,int target,int idx,List<List<Integer>> list,List<Integer> path){
        if(target==0){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i <candidates.length ; i++) {
            if(candidates[i]>target)
                return;

            if(i>idx && candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            dfsTWO(candidates,target-candidates[i],i+1,list,path);
            path.remove(path.size()-1);
        }
    }

     public static void main(String[] args) {
        int a[]={10,1,2,7,6,1,5};
        int target=8;
         System.out.println(combinationSum(a,target));
    }
}