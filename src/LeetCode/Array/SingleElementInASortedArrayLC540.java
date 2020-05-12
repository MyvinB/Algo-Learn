package LeetCode.Array;
/*
 @author Myvin Barboza
 12/05/20 2:34 PM 
 */

public class SingleElementInASortedArrayLC540 {

    static int singleNonDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            boolean isEven=(high-mid)%2==0;
            if(nums[mid]==nums[mid-1]){
                if(isEven){
                    high=mid-2;
                }else{
                    low=mid+1;
                }
            }
            else if(nums[mid]==nums[mid+1]){
                //if even that means the number is odd accounting for the number being added
                if(isEven){
                    low=mid+2;
                }else{
                    high=mid-1;
                }
            }
            else return nums[mid];
        }
        return nums[low];
    }


    static int singleNonDuplicateUsingXOR(int[] nums){
        int low=0;
        int high=nums.length-1;
        int n=nums.length;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]==nums[mid^1]){
                low=mid+1;
            }
            else high=mid;
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int nums[]={1,1,2};
        System.out.println(singleNonDuplicate(nums));
    }
}