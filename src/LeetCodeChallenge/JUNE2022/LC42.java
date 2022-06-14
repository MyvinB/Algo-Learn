package LeetCodeChallenge.JUNE2022;

public class LC42 {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int l = 0,r= n-1;
        while(l<=r){
            if(height[l]<=height[r]){
                if(height[l]>leftMax) leftMax = height[l];
                else res+= leftMax-height[l];
                l++;
            }
            else {
                if(height[r]>rightMax) rightMax = height[r];
                else res+= rightMax - height[r];
                r--;
            }
        }
        return res;
    }
}
