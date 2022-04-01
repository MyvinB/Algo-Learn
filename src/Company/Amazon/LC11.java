package Company.Amazon;

/**
 * @author mmichaelbarboza
 * on 7:40 AM 4/1/2022
 * Time Taken:
 */
public class LC11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;

//        //0(n2)
//        for(int i=0;i<n;i++){
//            for(int j=i+1;j<n;j++){
//                int area = (j-i) * Math.min(height[i],height[j]);
//                max = Math.max(area,max);
//            }
//        }
        int low = 0;
        int high = n-1;
        while(low<high){
            int area = (high-low) * Math.min(height[low],height[high]);
            max = Math.max(area,max);
            if(height[low]<height[high]){
                low = low+1;
            }else high = high-1;
        }
        return max;
    }
}
