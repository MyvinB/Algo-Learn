package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 6:34 AM 3/26/2022
 * Time Taken:
 */
public class LC704 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low +(high-low)/2;
            if(target>nums[mid]){
                low = mid+1;
            }else high = mid;
        }
        return nums[low]==target?low:-1;
    }
}
