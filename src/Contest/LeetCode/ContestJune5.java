package Contest.LeetCode;

import java.util.*;

public class ContestJune5 {

    public static void main(String[] args) {
//        int[] t = new int[]{93,40};
//        System.out.println(minMaxGame(t));
//        int[][] ta = new int[][]{{1000000,999999},{999999,999998},{999998,999997},{999997,999990}};
//        int[] p = new int[]{1000000};
//        System.out.println(Arrays.toString(arrayChange(p,ta)));
          int e[] = new int[]{1,2,3};
        System.out.println(partitionArray(e,1));
    }


    public static int minMaxGame(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<nums.length;i++) queue.offer(nums[i]);
        int[] t = Arrays.copyOf(nums,nums.length);

        int size = nums.length;
        while(size!=1){
            int flag=0,k=0;
            for(int i=0;i<size;i=i+2){
                if(flag==0){
                    t[k++] = Math.min(t[i],t[i+1]);
                    flag=1;
                }else{
                    t[k++] = Math.max(t[i],t[i+1]);
                    flag=0;
                }
            }
            size = k;
        }
        return t[0];
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            indexMap.put(nums[i],i);
        }
        for(int[] t:operations){
            int k = t[0];
            int val = t[1];
            if(!indexMap.containsKey(k)) continue;
            int index = indexMap.get(k);
            nums[index] = val;
            indexMap.put(val,index);
        }

        return nums;
    }
    //Upsolve
    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count =1;
        int prev= nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-prev>k){
                count++;
            }
            prev = nums[i];
        }
        return count;
    }
}
