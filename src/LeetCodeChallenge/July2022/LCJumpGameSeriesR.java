package LeetCodeChallenge.July2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LCJumpGameSeriesR {

    public static void main(String[] args) {
        int[] t = new int[]{7,6,9,6,9,6,9,7};
        System.out.println(minJumps(t));
    }

    public boolean canJump1LC55(int[] nums) {
        int n = nums.length-1;
        int lastPosIndex = n;
        for(int i=n;i>=0;i--){
            if(nums[i]+i>=lastPosIndex){
                lastPosIndex = i;
            }
        }
        return lastPosIndex==0;
    }

    public int jump2LC45(int[] nums) {
        int farthest = 0;
        int l=0,r=0;
        int n = nums.length-1;
        int bfsCount = 0;
        while(r<n){
            for(int i=l;i<r+1;i++){
                farthest  = Math.max(farthest,i+nums[i]);
            }
            l = r+1;
            r = farthest;
            bfsCount++;
        }
        return bfsCount;
    }

    public boolean canReach3LC1306(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int index = queue.poll();
                if(arr[index]==0) return true;
                if(!visited[index]){
                    int f = index+arr[index];
                    int b = index-arr[index];
                    if(f>=0 && f<n){
                        queue.offer(f);
                    }
                    if(b>=0 && b<n){
                        queue.offer(b);
                    }
                    visited[index] = true;
                }
            }
        }
        return false;
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Queue<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i],v->new LinkedList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.offer(0);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int index = queue.poll();
                if(index==n-1) return level;
                if(index+1<n && !visited[index+1]){
                    queue.offer(index+1);
                }
                if(index-1>=0 && !visited[index-1]){
                    queue.offer(index-1);
                }
                if(map.containsKey(arr[index])){
                    Queue<Integer> queueTemp = map.get(arr[index]);
                    while(!queueTemp.isEmpty()){
                        queue.offer(queueTemp.poll());
                    }
                }
                visited[index] = true;
            }
            level++;
        }
        return level;
    }
}
