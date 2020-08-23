package LeetCode.Math;/*
 @author Myvin Barboza
 23/08/20 5:54 PM 
 */

import java.util.Random;
import java.util.TreeMap;

public class LC497RandomPointinNonoverlappingRectangles {
    Random random;
    TreeMap<Integer,int[]> map;
    int area=0;

    public LC497RandomPointinNonoverlappingRectangles(int[][] rects) {
    random=new Random();
    map=new TreeMap<>();
        for(int r[]:rects){
            int x1=r[0],y1=r[1],x2=r[2],y2=r[3];
            area+=(x2-x1+1)*(y2-y1+1);
            map.put(area,r);
        }
    }

    public int[] pick() {
        int key=map.ceilingKey(random.nextInt(area)+1);
        int ar[]=map.get(key);
        int x=ar[2]-ar[0]+1;
        int y=ar[3]-ar[1]+1;
        int l=ar[0]+random.nextInt(x);
        int b=ar[1]+random.nextInt(y);
        return new int[]{l,b};
    }

}
