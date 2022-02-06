package LeetCodeChallenge.Feb2022;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 5:33 PM 2/6/2022
 * Time Taken:
 */
public class LC80 {

    public static void main(String[] args) {
        int[] t = new int[] {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(t));
        System.out.println(Arrays.toString(t));
    }

    public static int removeDuplicates(int[] nums) {
        int i=2;
        for(int j=2;j<nums.length;j++){
            if(nums[j]!=nums[i-2]){
                nums[i++]=nums[j];
            }
        }
        //Zero based indexing
        return i;
    }
}
