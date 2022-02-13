package LeetCodeChallenge.Feb2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 6:17 PM 2/13/2022
 * Time Taken:
 */
public class LC78 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(),res,0,nums);
        return res;
    }


    public void dfs(List<Integer> temp, List<List<Integer>> res, int i,int[] nums){
        //Very important to understand decision tree either choose element or dont
        //End case
        if(i>=nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //Choose the element
        temp.add(nums[i]);
        dfs(temp,res,i+1,nums);
        temp.remove(temp.size()-1);

        //Do not choose the element
        dfs(temp,res,i+1,nums);

    }
}
