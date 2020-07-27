package LeetCode.Math;/*
 @author Myvin Barboza
 27/07/20 1:06 PM 
 */

public class LC553OptimalDivision {

    public String optimalDivision(int[] nums) {
        if(nums.length==0) return "";
        StringBuilder sb=new StringBuilder();
        if(nums.length==1) return  ""+nums[0];
        if(nums.length==2) return nums[0]+"/"+nums[1];
        sb.append(nums[0]+"/("+nums[1]);

        for(int i=2;i<nums.length;i++){
            sb.append("/"+nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }

}
