package Contest.LeetCode;

/**
 * @author mmichaelbarboza
 * on 7:15 PM 3/27/2022
 * Time Taken:
 */
public class MinimumDeletionstoMakeArrayBeautiful {

    public static void main(String[] args) {
        int t[] = new int[]{1,1,2,3,5};
        System.out.println(minDeletion(t));
    }

    public static int minDeletion(int[] nums) {
      int n = nums.length;
      int count = 0;
      for(int i=0;i<n-1;i++){
          if(nums[i]==nums[i+1] && (i-count)%2==0){
              count++;
          }
      }
      if((n-count)%2!=0) count++;
      return count;
    }
}
