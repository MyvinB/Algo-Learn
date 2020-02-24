package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
///refer two sum if you dont get this problem on first short
public class ThreeSumLC15 {
		
	 static List<List<Integer>> threeSum(int[] nums) {
		  List<List<Integer>> res =new ArrayList<>();
		   if(nums.length==0||nums.length<3){
			   return res;
		   }
		   Arrays.sort(nums);
		   for (int i = 0; i < nums.length-2; i++) {
				if(i>0&&nums[i]!=nums[i-1]){
					int low=i+1;
					int high=nums.length-1;
					int sum=0-nums[i];
					while(low<high){
						
						if(sum==nums[low]+nums[high]){
							res.add(Arrays.asList(nums[i],nums[low],nums[high]));
							//to avoid duplocate elements  //to understand this use [-2,0,0,2,2] do a dry run we need distinct sets cant have it repeat
							while(low<high&&nums[low]==nums[low+1])low++;
							while(low<high&&nums[high]==nums[high-1])high--;
							low++;
							high--;
						}
						else if(nums[low]+nums[high]>sum){
							high--;
						}
						else if(nums[low]+nums[high]<sum){
							low++;
						}
					}
				}
						
		
			   }
	 return res;
	 }
		
		
		public static void main(String[] args) {
				int[] p={-1, 0, 1, 2, -1, -4};
				System.out.println(threeSum(p));
		}
}
