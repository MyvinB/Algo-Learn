package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 7:36 AM 2/21/2022
 * Time Taken:
 */
public class LC1004 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnesOpti(nums,2));
    }

    public static int longestOnes(int[] nums, int k) {
        int start =0,end=0,flippedCount=0, maxLength=0;
        while(end<nums.length){
            if(nums[end] == 1) end++;
            else{
                if(flippedCount<k){
                    flippedCount++;
                    end++;
                }else{
                    //Moving the start pointer till we get back ability to flip
                    while(flippedCount>=k){
                        if(nums[start]==0){
                            flippedCount--;
                        }
                        start++;
                    }
                }
            }
            System.out.println(start+" "+end);
            maxLength = Math.max(maxLength,end-start);
        }
        return maxLength;
    }


    public static int longestOnesOpti(int[] nums, int k){
        int i =0,j;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0) k--;
            if(k<0 && nums[i++]==0)k++;
            System.out.println(i+" "+j);
        }
        return j-i;
    }
}
