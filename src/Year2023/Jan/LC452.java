package Year2023.Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC452 {

    public static void main(String[] args) {
        int[][] t = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        int[][] e = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        System.out.println(findMinArrowShots(e));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->(Integer.compare(a[1],b[1])));
        int rightEndpoint = points[0][1];
        //We shoot the first baloon
        int toShoot = 1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]>rightEndpoint){
                toShoot++;
                rightEndpoint = points[i][1];
            }
        }
        return toShoot;
    }
}
