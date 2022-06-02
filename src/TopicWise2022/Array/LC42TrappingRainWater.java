package TopicWise2022.Array;

public class LC42TrappingRainWater {

    public static void main(String[] args) {
        System.out.println();
    }

    public int trap(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // [  0,1,1,2,2,2,2,3,3,3,3,3]
        // [  3,3,3,3,3,3,3,3,2,2,2,1]
        int n = height.length;
        int[] leftMax = new int[n+1];
        for(int i=0;i<n;i++){
            leftMax[i+1] = Math.max(leftMax[i],height[i]);
        }
        int rightMax =0;
        int total =0;
        for(int i=n-1;i>=0;i--){
            rightMax = Math.max(rightMax,height[i]);
            int water = Math.min(leftMax[i],rightMax)-height[i];
            if(water>0) total+=water;
        }
        return total;
    }
}
