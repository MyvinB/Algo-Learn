package LeetCodeChallenge.MAY2022;

public class LC905 {

    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i]%2==0)i++;
            if(nums[j]%2!=0)j--;
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
