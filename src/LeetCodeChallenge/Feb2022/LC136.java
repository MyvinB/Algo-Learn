package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 4:39 PM 2/15/2022
 * Time Taken:
 */
public class LC136 {

    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
}
