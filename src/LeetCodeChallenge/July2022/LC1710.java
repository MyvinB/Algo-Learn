package LeetCodeChallenge.July2022;

import java.util.Arrays;

public class LC1710 {

    public static void main(String[] args) {
        int [][] t = new int[][]{{1,3},{2,2},{3,1}};
        int [][] p = new int[][]{{5,10},{2,5},{4,7},{3,9}};
        //System.out.println(maximumUnits(t,4)); 8
        System.out.println(maximumUnits(p,10));

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{return b[1]-a[1];});
        int remN= truckSize;
        int sum = 0;
        for(int[] t:boxTypes){
            if(remN>t[0]){
                remN-= t[0];
                sum += (t[0] * t[1]);
            }else {
                sum += remN * t[1];
                return sum;
            }
        }
        return sum ;
    }
}
