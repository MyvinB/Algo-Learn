package Contest.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 8:24 PM 4/2/2022
 * Time Taken:
 */
public class TriangularSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        List<Integer> r = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            r.add(nums[i]);
        }

        while(r!=null){
            List<Integer> temp = new ArrayList<>();
            if(r.size() == 1) break;
            for(int i=0;i<r.size()-1;i++){
               temp.add( (r.get(i) +r.get(i+1))%10);
            }
            r = temp;
        }
        return r.get(0);
    }
}
