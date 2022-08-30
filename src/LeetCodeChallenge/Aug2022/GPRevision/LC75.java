package LeetCodeChallenge.Aug2022.GPRevision;

public class LC75 {

    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int lo =0;
        int hi= nums.length-1;
        int cur = 0;
        while(cur<=hi){
            if(nums[cur]==0){
                swap(lo++,cur++,nums);
            }else if(nums[cur]==2){
                swap(hi--,cur,nums);
            }
            else cur++;
        }
    }

    public void swap(int i, int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
