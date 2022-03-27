package LeetCodeChallenge.MAR2022;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author mmichaelbarboza
 * on 6:02 PM 3/27/2022
 * Time Taken:
 */
public class LC1337 {
    public static void main(String[] args) {

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int cmp = a[0]-b[0];
            if(cmp!=0) return cmp;
            return a[1]-b[1];
        });
        for(int i=0;i<mat.length;i++){
            pq.offer(new int[]{findIndex(mat[i]),i});
        }
        int ar[] = new int[k];
        int i=0;
        while(!pq.isEmpty() && i<k){
            ar[i++] = pq.poll()[0];
        }
        return ar;
    }

    public int findIndex(int[] nums){
        int low =0;
        int high =nums.length;
        while(low<high){
            int mid = low+ (high-low)/2;
            if(nums[mid]==1){
                low=mid+1;
            }
            else high=mid;
        }
        return low;
    }

}
