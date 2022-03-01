package LeetCodeChallenge.Feb2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 11:51 AM 2/28/2022
 * Time Taken:
 */
public class LC288 {

    public static void main(String[] args) {
        summaryRanges(new int[]{0,2,3,4,6,8,9});
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<nums.length;){
            int start = i;
            int end = -1;
            while(i<nums.length-1 && nums[i+1] == nums[i] + 1){
                i++;
                end = i;
            }
            i++;
            if(end == -1){
                list.add(nums[start]+"");
            }
            else
            list.add(nums[start]+"->"+nums[end]);
        }
        System.out.println(list);
        return list;
    }
}


