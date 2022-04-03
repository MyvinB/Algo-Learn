package LeetCodeChallenge.APR2022;

/**
 * @author mmichaelbarboza
 * on 6:33 AM 4/3/2022
 * Time Taken:
 */
public class LC31 {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index  = -1;
        //13542 index is at 1
        // 1) find decreasing order from the back
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        // 14532
        // After finding the index swap the next minimum from the back
        if(index!=-1){
            for(int i=n-1;i>=0;i--){
                if(nums[i]>nums[index]){
                    swap(nums,i,index);
                }
            }
        }


        //Swap number to form increasing order from decreasing
        //14235
        int low = index+1;
        int high = n-1;
        while(low<high){
            swap(nums,low,high);
            low++;
            high--;
        }

    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
