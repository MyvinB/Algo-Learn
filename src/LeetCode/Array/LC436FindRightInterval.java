package LeetCode.Array;

import java.util.Arrays;
import java.util.HashMap;

public class LC436FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int first[]=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i][0],i);
            first[i]=intervals[i][0];
        }
        Arrays.sort(first);

        int res[]=new int[intervals.length];
        for(int i=0;i<res.length;i++){
            int idx=binarySearch(first,intervals[i][1]);
            res[i]=idx==-1?-1:map.get(first[idx]);
        }
        return res;
    }

    int binarySearch(int[] first,int target){
        int ans=-1;
        int low=0,high=first.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(first[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else  low=mid+1;
        }

        return ans;
    }
}
