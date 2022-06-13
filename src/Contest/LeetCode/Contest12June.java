package Contest.LeetCode;

import java.util.HashMap;

public class Contest12June {

    public static void main(String[] args) {
//
//        int[][] t = new int[][]{{1,0},{4,25},{5,50}};
//        System.out.println(calculateTax(t,2));

        int c[]  = new int[]{8,15,10,20,8};
        System.out.println(distributeCookies(c,2));
    }

    public static double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int prev = 0;
        for(int[] b:brackets){
            int earned = Math.min(b[0],income)-prev;

            int tax = b[1];
            double val = (earned * tax *1.0)/100D;
            System.out.println(earned+"val"+val);
            res +=val;
            if(income == Math.min(b[0],income)) break;
            prev = b[0];
        }
        return res;
    }


    public static int distributeCookies(int[] cookies, int k) {
        int max =0;
        for(int i=0;i<cookies.length;i++){
            max+= cookies[i];
        }

        int lo = 0;
        int hi = max;
        int lastMinDiff = Integer.MAX_VALUE;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,0);
            int preSum =0;
            int minDiff = Integer.MAX_VALUE;
            for(int i=0;i<cookies.length;i++){
                preSum+= cookies[i];
                if(map.containsKey(preSum-mid)){
                    int h1 = mid;
                    int h2 = max-h1;
                    if(Math.abs(h2-h1)<minDiff){
                        minDiff = Math.abs(h2-h1);
                    }
                }
                map.put(preSum,i);
            }
            if(lastMinDiff>minDiff){
                hi=mid;
            }else lo = mid+1;
        }
        return lo;
    }

}
