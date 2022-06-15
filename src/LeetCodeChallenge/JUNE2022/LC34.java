package LeetCodeChallenge.JUNE2022;

public class LC34 {

    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1,-1};
        int lo=0,hi= nums.length;
        //First lookign in left half to get index first
        //when we check > that means if we look to the left half as me make high = mid;
        while(lo<hi){
            int mid = lo +(hi-lo)/2;
            if(nums[mid]<target) lo=mid+1;
            else hi = mid;
        }
        if(nums[lo]==target) res[0] = lo;
        lo=0;hi = n;
        //Now looking to the right half when we check < that means if the value is equal we look to the left half as we put low = mid
        while(lo<hi){
            int mid = lo+(hi-lo)/2+1;//do this to avoid infnite loop
            if(nums[mid]>target) hi= mid-1;
            else lo = mid;
        }
        if(nums[lo]==target) res[1] = hi;
        return res;
    }
}
