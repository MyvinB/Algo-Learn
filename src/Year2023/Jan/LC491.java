package Year2023.Jan;

import Challenge.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC491 {

    public static void main(String[] args) {
        int[] t = new int[]{4,6,7,7};
        System.out.println(findSubsequences(t));
    }
//[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
    public static List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,Integer.MIN_VALUE,new ArrayList<>(),set,res);
        return res;
    }

    public static void backtrack(int[] nums, int idx, int prev, List<Integer> temp, HashSet<List<Integer>> set,List<List<Integer>> res){
        if(temp.size()>=2 && set.add(new ArrayList<>(temp))){
            res.add(new ArrayList<>(temp));
        }
        if(idx==nums.length) return ;
        //Considering the value if its greater
        if (nums[idx] >= prev) {
            temp.add(nums[idx]);
            backtrack(nums, idx + 1, nums[idx], temp, set,res);
            temp.remove(temp.size()-1);
        }
        //Lets not consider the current value and move forward and use the prev as the prev only
        //Understand you can also use a for loop for the same something of the sort it basically does the same thing
        // and is a typical backtracking template
//
//        for(int i = idx;i<arr.length;i++){
//          if (nums[idx] >= prev) {
//            temp.add(nums[idx]);
//            backtrack(nums, idx + 1, nums[idx], temp, set,res);
//            temp.remove(temp.size()-1);
//            }
//         }
        backtrack(nums,idx+1,prev,temp,set,res);
    }

}
