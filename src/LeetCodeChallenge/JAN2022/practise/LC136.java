package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 4:13 PM 1/8/2022
 */
public class LC136 {

    public static void main(String[] args) {
      int[] a = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
}

