package LeetCodeChallenge.MAR2022;

/**
 * @author mmichaelbarboza
 * on 9:11 AM 3/31/2022
 * Time Taken:
 */
public class LC410 {

    public static void main(String[] args) {
        int[] t = new int[]{7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(t,2));
    }

    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for(int i:nums){
            max= Math.max(max,i);
            sum+=i;
        }
        int low = max;
        int high = sum;
        while(low<high) {
            int mid = low + (high - low) / 2;
            if (valid(mid, nums, m)) {
                high = mid;
            } else low = mid + 1;
        }
        return low;
    }


    public static boolean valid(int target,int[] nums,int m){
        int count = 1;
        int sum = 0;
        for(int i:nums){
            sum+=i;
            //time to split it when sum > target so start from the element it self and increase the count to indicate split
            if(sum>target){
                sum = i;
                count++;
            }
            if(count>m) return false;
        }
        return true;
    }
}
