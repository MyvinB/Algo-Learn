package LeetCode.Math;
/*
 @author Myvin Barboza
 12/06/20 7:57 AM 
 */

public class LC69Sqrtofx {

    static int mySqrt(int x) {
        if(x==0) return 0;
        int low=1,high=x;
        while(low<=high){
            int mid=low+ (high-low)/2;
            if(mid<=x/mid){
                low=mid+1;
            }
            else high=mid-1;
        }
        return low-1;
    }

    public static void main(String[] args) {
        System.out.println( mySqrt(8));
    }
}