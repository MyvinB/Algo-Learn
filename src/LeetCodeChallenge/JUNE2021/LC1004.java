package LeetCodeChallenge.JUNE2021;

public class LC1004 {

    public static int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        while(i<nums.length){
            if(nums[i] == 0){
                k--;
            }
            if(k<0){
                if(nums[j] == 0){
                    k++;
                }
                j++;
            }
            i++;

        }
        return i-j;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        /**
         *->0,0,1,1,0 i =4 k=0 j=0
         0,*->0,1,1,0,0 i=5 j=1 k=1


         */
        System.out.println(longestOnes(nums,3));
    }
}
