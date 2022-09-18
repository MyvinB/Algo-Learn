package LeetCodeChallenge.Sep2022.DailyChallenege;

public class LC42 {

    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int n = height.length;
        int leftMax = Integer.MIN_VALUE,rightMax = Integer.MIN_VALUE;
        int res = 0,l= 0,r=n-1;
        //Find res with respect to min
        //if we find the minimum in the left side that means to the right side there is something greater hence we take min and vice versa
        while(l<r){
            if(height[l]<=height[r]){
                //if
                if(height[l]>leftMax) leftMax = height[l];
                else res = leftMax-height[l++];
            }
            else{
                if(height[r]>rightMax) rightMax = height[r];
                else res = rightMax - height[r--];
            }
        }
        return res;
    }
}
