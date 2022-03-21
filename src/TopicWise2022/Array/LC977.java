package TopicWise2022.Array;

/**
 * @author mmichaelbarboza
 * on 3:56 PM 3/20/2022
 * Time Taken:
 */
public class LC977 {

    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        int i = n-1;
        int[] result = new int[n];
        while(low<=high && i>=0){
            if(Math.abs(nums[low])>Math.abs(nums[high])){
                result[i--] = nums[low]*nums[low];
                low++;
            }else {
                result[i] = nums[high]*nums[high];
                high--;
            }

        }
        return result;
    }
}
