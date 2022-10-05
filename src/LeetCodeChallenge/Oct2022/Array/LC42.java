package LeetCodeChallenge.Oct2022.Array;

public class LC42 {

    public static void main(String[] args) {

    }
    //Think like if yuu take something lower on the left there is something higer at the rigth to hold the water
    // now if we find something bigger then what we already have we cannot calculate any store water basic intution
    public int trap(int[] height) {
        int l= 0,r=height.length-1,res =0;
        int leftMax = Integer.MIN_VALUE,rightMax = Integer.MIN_VALUE;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>leftMax) leftMax = height[l];
                else res += leftMax-height[l++];
            }else {
                if(height[r]>rightMax) rightMax = height[r];
                else res += rightMax-height[r--];
            }
        }
        return res;
    }
}
