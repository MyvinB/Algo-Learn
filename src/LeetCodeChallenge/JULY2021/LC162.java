package LeetCodeChallenge.JULY2021;

public class LC162 {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
    //Naive o(n) approach
    public static int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<nums[i-1]){
                return i-1;
            }
        }
        return nums.length-1;
    }

    public static int findPeakElementA(int[] nums) {
        int l=0,h=nums.length-1;
        while(l<h){
            int mid = l+ (h-l)/2;
            if(nums[mid]<nums[mid+1]){
                l=mid+1;
            }else h=mid;
        }
        return l;
    }


}
