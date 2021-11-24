package practise;

import Challenge.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 10:34 AM 11/24/2021
 */
public class LC46 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums,res,new ArrayList<>());
        return res;
    }

    public static void backTrack(int[] nums,List<List<Integer>> res,List<Integer> tempList){
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(!tempList.contains(nums[i])){
                    tempList.add(nums[i]);
                    backTrack(nums,res,tempList);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
}
