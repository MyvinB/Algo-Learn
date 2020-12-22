package LeetCodeChallenge.December;/*
 @author Myvin Barboza
 22/12/20 7:29 PM 
 */

import java.util.Arrays;

public class LC910SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N-1]-A[0];
        for(int i=0;i<N-1;i++){
            int a = A[i],b = A[i+1];
            int high = Math.max(A[N-1]-K,a+K);
            int low = Math.min(A[0]+K,b-K);
            ans = Math.min(ans,high-low);
        }
        return ans;
    }

}
