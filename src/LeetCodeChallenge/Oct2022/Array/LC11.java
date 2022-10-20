package LeetCodeChallenge.Oct2022.Array;

public class LC11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int h = height.length-1;
        int l = 0;
        int res = 0;
        while(l<h){
            int area = (h-l)* Math.min(height[l],height[h]);
            res = Math.max(res,area);
            //We always move the lowe one cause that is the area we can consider
            if(height[l]<height[h]){
                l++;
            }else h--;
        }
        return res;
    }
}
