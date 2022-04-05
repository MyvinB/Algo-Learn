package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 12:36 PM 4/5/2022
 * Time Taken:
 */
public class LC11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length;
        int maxArea = 0;
        while(low<high){
            int area = (high-low) * Math.min(height[low],height[high]);
            maxArea = Math.max(area,maxArea);
            if(height[low]<height[high]){
                low = low +1;
            }
            else high = high-1;
        }
        return maxArea;
    }
}
