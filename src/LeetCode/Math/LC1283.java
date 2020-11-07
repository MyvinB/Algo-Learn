package LeetCode.Math;

public class LC1283 {
    public static void main(String[] args) {

    }

    public int smallestDivisor(int[] nums, int threshold) {
    int left=1,right= (int)1e6;
    while(left<right){
        int m= (left+right)/2;
        int sum=0;
        for(int i:nums)
            sum +=(i+m-1)/m;
        if(sum>threshold)
            left=m+1;
        else
            right=m;
    }

    return left;
    }
}
