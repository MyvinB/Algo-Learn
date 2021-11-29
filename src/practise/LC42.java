package practise;

/**
 * @author mmichaelbarboza
 * on 11:22 AM 11/29/2021
 */
public class LC42 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trapConstantSpace(height));
    }
    //time->o(n) space->o(n)
    public static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max= Math.max(max,height[i]);
            leftMax[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            max=Math.max(max,height[i]);
            rightMax[i]=max;
        }
        int res =0;
        for(int i=1;i<height.length-1;i++){
            res+= Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return res;
    }

    public static int trapConstantSpace(int[] height) {
        int l=0;
        int r=height.length-1;
        int lmax = height[l];
        int rmax = height[r];
        l++;r--;
        int res =0;
        while(l<=r){

            if(lmax<=rmax){
                if(height[l]>lmax) lmax =height[l];
                else res += lmax-height[l];
                l++;
            }
            else {
                if(height[r]>rmax) rmax =height[r];
                else res += rmax-height[r];
                r--;
            }

        }
        return res;
    }
}
