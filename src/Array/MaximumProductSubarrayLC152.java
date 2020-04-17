package Array;

/*
 @author Myvin Barboza
 16/04/20 5:09 PM 
 */

public class MaximumProductSubarrayLC152 {

   static int maxProduct(int[] nums) {
       int t=1;
       int max=Integer.MIN_VALUE;
       for (int i = 0; i <nums.length ; i++) {
           if(nums[i]==0 && 0>max){max=0;continue;}

           t=nums[i]*t;
            if(t>max)max=t;
            else{
                t=t/nums[i];
                t=1;
            }
       }
       return max;
    }

    public static void main(String[] args) {
    int a[]={-2,0,-1};
        System.out.println(maxProduct(a));
    }
}