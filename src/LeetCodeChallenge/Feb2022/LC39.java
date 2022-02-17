package LeetCodeChallenge.Feb2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 8:50 AM 2/17/2022
 * Time Taken:
 */
public class LC39 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),res,0);
        return res;
    }


    public void dfs(int[] candidates,int remain,List<Integer> temp, List<List<Integer>> res,int start){
        if(remain<0) return;
        else if(remain==0) res.add(new ArrayList<>(temp));
        else{
            for(int i=start;i<candidates.length;i++){
                temp.add(candidates[i]);
                dfs(candidates,remain-candidates[i],temp,res,i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
