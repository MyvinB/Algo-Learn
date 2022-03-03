package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 9:06 AM 3/3/2022
 * Time Taken:
 */
public class LC413 {

    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[]{1,2,3,4});
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int count  = 0;
        int res = 0;
         // a b c d -> if a b c is a slice and b c d is a slice that means a b c d is a slice so we look one back to get the slices populated.
        for(int i=2;i<n;i++){
            int preIndex = i-2;
            int midIndex = i-1;
            if(nums[midIndex]-nums[preIndex] == nums[i]-nums[midIndex]){
                count++;
            }else {
                // since its sum of n numbers ie (n*(n+1))/2
                res += (count * (count+1))/2;
                count = 0;
            }
        }
        //if the whole last part is a slice never calc the last part hence the extra add
        res += (count * (count+1))/2;
        System.out.println(res);
        return res;
    }
}
