package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 4:25 PM 1/8/2022
 */
public class LC169 {
    public static void main(String[] args) {
        int[] a = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(a));
    }
    //Moore Voting algo
    public static int majorityElement(int[] nums) {
        int majority = 0;
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[majority]){
                count++;
            }else count--;
            if(count==0){
                majority = i;
                count=1;
            }

        }
        return nums[majority];
    }
}
