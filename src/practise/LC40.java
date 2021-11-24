package practise;

import Challenge.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 12:48 PM 11/24/2021
 */
public class LC40 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
                //1,1,2,5,6,7,10
        System.out.println(combinationSum2(nums,8));
    }


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backTrack(candidates,target,list,new ArrayList<>(),0);
        return list;
    }

    public static void backTrack(int[] candidates,int remain, List<List<Integer>> res,List<Integer> tempList,int start){
        if(remain<0) return;
        else if(remain==0) {
            res.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = start;i<candidates.length;i++){
                /*To see a combination already been created when the index is grater than start
                1 1 2 5 6 7 10
                Here 1 2 5 gets created one time
                 the second time on index 1 it creates a check where 1 is greater than start and compares and sees if its already been processed
                * */
                if(i>start && candidates[i]== candidates[i-1])continue;
                tempList.add(candidates[i]);
                backTrack(candidates,remain-candidates[i],res,tempList,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
