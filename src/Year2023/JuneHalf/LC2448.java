package Year2023.JuneHalf;

public class LC2448 {

    public static void main(String[] args) {

    }


    ///USing binary search
    public long minCost(int[] nums, int[] cost) {
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            l = Math.min(l,nums[i]);
            h = Math.max(h,nums[i]);
        }
        long ans = Long.MAX_VALUE;
        System.out.println(l+" "+h);
        while(l<=h){
            int mid = l + (h-l)/2;
            long cost1 = getCost(nums,cost,mid);
            long cost2 = getCost(nums,cost,mid+1);
            System.out.println(cost1+" "+cost2);
            if(cost1<=cost2){
                h = mid-1;
            }else{
                l = mid+1;
            }
            ans = Math.min(ans,Math.min(cost1,cost2));
        }
        return ans;
    }

    public long getCost(int[] nums,int[] cost, int c){
        long total = 0L;
        for(int i=0;i<nums.length;i++){
            total+=1L*Math.abs(nums[i]-c) * cost[i];
        }
        return total;
    }
}
