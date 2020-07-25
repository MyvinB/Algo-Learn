package LeetCode.Array;/*
 @author Myvin Barboza
 25/07/20 1:37 PM 
 */

public class LC42TrappingRainWater {

    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int leftMax[]=new int[height.length+1];
        int rightMax=0;
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // [  0,1,1,2,2,2,2,3,3,3,3,3]
        // [  3,3,3,3,3,3,3,3,2,2,2,1]
        for(int i=0;i<height.length;i++){
            leftMax[i+1]=Math.max(leftMax[i],height[i]);
        }
        int total=0;
        for(int i=height.length-1;i>=0;i--){
            rightMax=Math.max(rightMax,height[i]);
            int min=Math.min(rightMax,leftMax[i])-height[i];
            if(min>0) total+=min;
        }
        return total;
    }

}
