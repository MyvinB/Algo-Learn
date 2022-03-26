package TopicWise2022.BinarySearch;

/**
 * @author mmichaelbarboza
 * on 7:04 AM 3/26/2022
 * Time Taken:
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length==0) return res;
        int index = 0;
        int low = 0;
        int high = nums.length-1;
        //First lookign in left half to get index first
        //when we check > that means if we look to the left half as me make high = mid;
        //Why infinite loop is not possible here cause mid is biased and always becomes low and we go and chgange the low
        while(low<high){
            int mid  = low+(high-low)/2;
            if(target>nums[mid]){
                low=mid+1;
            }else high=mid;
        }
        if(nums[low]==target) res[0] = low;
        else res[0] = -1;
        low = 0;
        high = nums.length-1;
        //Now looking to the right half when we check < that means if the value is equal we look to the left half as we put low = mid
        //Clear cut case of infinty loop
        //Why infinite loop is  possible if we do not add +1 here cause mid is biased and always becomes low and low is not moving
        while(low<high){
            int mid = low +(high-low)/2+1; //do this to avoid infnite loop
            if(target<nums[mid]){
                high=mid-1;
            }else low=mid;
        }
        if(nums[low]==target) res[1] = low;
        else res[1] = -1;
        return res;
    }
}
