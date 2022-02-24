package Company.MorganStanley;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:17 AM 2/24/2022
 * Time Taken:
 */
public class LC31 {

    public static void main(String[] args) {
//        https://www.youtube.com/watch?v=LuLCLgMElus
        //Striver you rock
        int[] t = new int[]{3,2,1};
        nextPermutation(t);
        System.out.println(Arrays.toString(t));
    }

    public static void nextPermutation(int[] nums) {
        //Step 1 Find a number which is increasing
        //3 2 1
        int index = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        if(index != -1){
            for(int i = nums.length-1;i>=0;i--){
                if(nums[i]>nums[index]){
                    swap(nums,i,index);
                    break;
                }
            }
        }
        int low = index+1;
        int high = nums.length-1;
        while(low<high){
            swap(nums,low,high);
            low++;
            high--;
        }
    }

    static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
