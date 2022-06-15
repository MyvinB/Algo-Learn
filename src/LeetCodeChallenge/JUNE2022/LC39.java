package LeetCodeChallenge.JUNE2022;

import java.util.ArrayList;
import java.util.List;

public class LC39 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,res,new ArrayList<>(),target,0);
        return res;
    }

    public void backtrack(int[] candidates,List<List<Integer>> res, List<Integer> temp,int remaining,int start){
        int n = candidates.length;
        if(remaining<0) return;
        else if(remaining==0) res.add(new ArrayList<>(temp));
        else{
            for(int i=start;i<n;i++){
                temp.add(candidates[i]);
                backtrack(candidates,res,temp,remaining-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }
    }



}
