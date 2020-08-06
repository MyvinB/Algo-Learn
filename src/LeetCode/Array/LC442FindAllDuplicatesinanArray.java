package LeetCode.Array;/*
 @author Myvin Barboza
 06/08/20 3:01 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC442FindAllDuplicatesinanArray {
    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res =new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0)
                res.add(Math.abs(nums[i]));
            else
                nums[index]=-nums[index];
        }
        return res;
    }

}
