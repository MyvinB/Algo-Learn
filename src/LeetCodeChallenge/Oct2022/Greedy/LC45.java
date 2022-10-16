package LeetCodeChallenge.Oct2022.Greedy;

public class LC45 {

    public static void main(String[] args) {
        int[] t = new int[]{2,3,1,1,4};
        System.out.println(jump(t));
    }

    public static int jump(int[] nums) {
        int reach = 0;
        int l=0,r=0;
        int n = nums.length-1;
        int bfsCount = 0;
        while(r<n){
            for(int i=l;i<=r;i++){
                reach = Math.max(reach,nums[i]+i);
            }
            l = r+1;
            r = reach;
            bfsCount++;
        }
        return bfsCount;
    }

}
