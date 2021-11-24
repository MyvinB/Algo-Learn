package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 12:34 PM 11/24/2021
 */
public class LC39 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5};
        Arrays.sort(nums);
        System.out.println(combinationSum(nums,8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(candidates,target,list,new ArrayList<>(),0);
        return list;
    }

    public static void backTrack(int[] candidates,int remain,List<List<Integer>> res,List<Integer> tempList,int start){
        if(remain<0) return;
        else if(remain==0) {
            res.add(new ArrayList<>(tempList));
        }
        else{
            for(int i=start;i<candidates.length;i++){
                tempList.add(candidates[i]);
                backTrack(candidates,remain-candidates[i],res,tempList,i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
