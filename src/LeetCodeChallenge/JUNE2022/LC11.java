package LeetCodeChallenge.JUNE2022;

public class LC11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int n = height.length;
        int lo = 0;
        int hi = n-1;
        int res = 0;
        while(lo<hi){
            int area = (hi-lo) * Math.min(height[lo],height[hi]);
            res = Math.max(res,area);
            if(height[lo]<height[hi]){
                lo++;
            }
            else hi--;
        }
        return res;
    }
}
