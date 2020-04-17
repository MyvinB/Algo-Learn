package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 @author Myvin Barboza
 17/04/20 12:13 PM 
 */
public class TwoSumIILC167 {
    public static void main(String[] args) {
        int a[]={2,7,11,15};
        int target=9;
        int r[]=new int[2];
        int low=0;
        int high=a.length-1;
        while(low<high){
            int t=a[low]+a[high];
            if(t-target==0)
            {
                r[0]=a[low]; r[1]=a[high];
                break;

            }
            else if(t>target)--high;
            else if(t<target)++low;

        }
        System.out.println(Arrays.toString(r));
    }
}