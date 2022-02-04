package Company.ZopSmart;

/**
 * @author mmichaelbarboza
 * on 6:03 PM 2/4/2022
 * Time Taken:
 */
public class LC1464 {
    public static void main(String[] args) {
        int[] t = new int[]{3,4,5,2};
        System.out.println(maxProduct(t));
    }

    public static int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
           if(nums[i]>firstMax){
               secondMax=firstMax;
               firstMax=nums[i];
           }else if(nums[i]>secondMax){
               secondMax = nums[i];
           }
        }
        return (firstMax-1)*(secondMax-1);
    }
}
