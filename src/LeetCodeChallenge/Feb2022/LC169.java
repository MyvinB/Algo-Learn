package LeetCodeChallenge.Feb2022;

/**
 * @author mmichaelbarboza
 * on 6:38 AM 2/21/2022
 * Time Taken:
 */
public class LC169 {

    public static void main(String[] args) {
        /*
        * This solution works because its given that the candidate does exist in the array. Since its true, the candidate's occurance is greater than ">" half. The count variable keeps track of just that. If the candidate appears randomly in the array, it will keep the count up for its own occurance cancelling out the other ones - Hope this helps to understand Boyer Moore's algorithm that has been implemented in above code
        * */
    }

    public int majorityElement(int[] nums) {
         int majority = 0;
         int count = 1;
         for(int i=0;i<nums.length;i++){
             if(nums[i]==nums[majority]){
                 count++;
             }else{
                 count--;
             }
             if(count==0){
                 majority = i;
                 count=1;
             }
         }
         return nums[majority];
    }
}
