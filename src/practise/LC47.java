package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 11:12 AM 11/24/2021
 */
public class LC47 {

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Arrays.sort(nums);
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,res,new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    public static void backTrack(int[] nums,List<List<Integer>> res,List<Integer> tempList,boolean[] check){
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
        }else{
//            Thinking of the check[i-1] to see if this solution is already backtracked as check[i-1] will never be false unless it is coming back in the recursion tree
            for(int i=0;i<nums.length;i++){
                if(check[i] || i>0 && nums[i]==nums[i-1] && !check[i-1])continue;
                check[i] = true;
                tempList.add(nums[i]);
                backTrack(nums,res,tempList,check);
                check[i]= false;
                tempList.remove(tempList.size()-1);
            }
        }
    }

}
