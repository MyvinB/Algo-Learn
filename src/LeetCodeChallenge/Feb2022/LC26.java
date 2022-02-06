package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 6:27 PM 2/6/2022
 * Time Taken:
 */
public class LC26 {

    public static void main(String[] args) {
        int[] t = new int[]{0,0,1,1,1,2,2,3,3,4};
    }

    public int removeDuplicates(int[] nums) {
        int i=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i-1]){
                nums[i++]=nums[j];
            }
        }
        //Zero based indexing
        return i;

    }
}
