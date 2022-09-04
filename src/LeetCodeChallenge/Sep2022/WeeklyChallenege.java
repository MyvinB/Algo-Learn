package LeetCodeChallenge.Sep2022;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class WeeklyChallenege {

    public static void main(String[] args) {
        int[][] t = new int[][]{{1,0,1,1,1,1},{0,0,0,1,1,0},{1,1,0,0,0,0},{0,0,1,1,0,1}};
        System.out.println(maximumRows(t,2));
    }

    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<nums.length;i++){
            int sum = nums[i]+nums[i-1];
            if(!set.add(sum)) return true;
        }
        return false;
    }

    public static int maximumRows(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;
        int[] store = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1)
                    store[j]++;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++){
            pq.offer(new int[]{i,store[i]});
        }
        while(cols-->0){
            pq.poll();
        }
        while(!pq.isEmpty()){
            set.add(pq.poll()[0]);
        }
        int toDecre = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(set.contains(j) && mat[i][j]==1){
                    toDecre++;
                }
            }
        }
        return m-toDecre<0?0:m-toDecre;

    }


}
