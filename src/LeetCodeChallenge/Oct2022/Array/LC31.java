package LeetCodeChallenge.Oct2022.Array;

public class LC31 {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        //13542
        //1 Find the decreasing order index first
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        //14532
        //2 Find the next number greater than the number at the index from the back
        if(idx!=-1){
            for(int i=n-1;i>=0;i--){
                if(nums[idx]<nums[i]){
                    swap(nums,i,idx);
                    break;
                }
            }
        }
        //14235
        //3 Since we have all the numbers from the index in decreasing order so use a two pointer swap to get them in ascending order
        int i = idx+1, j = n-1;
        while(i<j){
            swap(nums,i++,j--);
        }
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
