package LeetCodeChallenge.Sep2022.DailyChallenege;

public class LC985 {

    public static void main(String[] args) {

    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int sumOfEven = 0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0) sumOfEven+= nums[i];
        }
        int[] ans = new int[n]; int k = 0;
        int temp = sumOfEven;
        for(int[] q:queries){
            if(nums[q[1]]%2==0){
                temp -= nums[q[1]];
            }
            if((nums[q[1]]+q[0])%2==0){
                temp += (nums[q[1]]+q[0]);
            }
            nums[q[1]] = (nums[q[1]]+q[0]);
            ans[k++] = temp;
        }
        return ans;
    }
}
