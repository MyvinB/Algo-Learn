package LeetCodeChallenge.July2022;

import java.util.Arrays;

public class LC1465 {

    public static void main(String[] args) {
        int[] h = new int[]{2};
        int[] v = new int[]{2};
        System.out.println(maxArea(1000000000,1000000000,h,v));

    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(verticalCuts);
        Arrays.sort(horizontalCuts);
        int maxH = 0,maxV=0,hN = horizontalCuts.length,vN = verticalCuts.length;
        maxH = horizontalCuts[0];
        for(int i=0;i<hN-1;i++){
            maxH = Math.max(maxH,(horizontalCuts[i+1]-horizontalCuts[i]));
        }
        maxH = Math.max(maxH,(h-horizontalCuts[hN-1]));
        maxV = verticalCuts[0];
        for(int i=0;i<vN-1;i++){
            maxV = Math.max(maxV,(verticalCuts[i+1]-verticalCuts[i]));
        }
        maxV = Math.max(maxV,(w-verticalCuts[vN-1])%mod);
        return (int)((long)maxH *maxV%mod);
    }
}
