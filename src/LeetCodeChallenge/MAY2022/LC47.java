package LeetCodeChallenge.MAY2022;

import Challenge.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {

    public static void main(String[] args) {

    }

    public  List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean used[] = new boolean[n];
        Arrays.sort(nums);
        backTrack(nums,res,new ArrayList<>(),used);
        return res;
    }

    private void backTrack(int[] nums,List<List<Integer>> res, List<Integer> cur,boolean used[]){
        int n = nums.length;
        if(cur.size()==n){
            res.add(new ArrayList<>(cur));
        }else {
            for(int i=0;i<n;i++){
                //Already used
                if(used[i]) continue;
                //Duplicate element
                if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                cur.add(nums[i]);
                backTrack(nums,res,cur,used);
                used[i] = false;
                cur.remove(cur.size()-1);
            }
        }
    }
}
