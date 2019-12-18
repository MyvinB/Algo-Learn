/*https://www.youtube.com/watch?v=3u59zv-c7go
 
 *Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	   static List<List<Integer>> threeSum(int[] nums) {
	   List<List<Integer>> res =new ArrayList<>();
	   if(nums.length==0||nums.length<3){
		   return res;
	   }
	   Arrays.sort(nums);
	   for (int i = 0; i < nums.length-2; i++) {
		if(i>0&&nums[i]==nums[i-1])
				continue;
		int low=i+1;
		int high=nums.length-1;
		while(low<high){
			int sum=nums[i]+nums[low]+nums[high];
			if(sum==0){
				List<Integer> l=new ArrayList<>();
				l.add(nums[i]);
				l.add(nums[low]);
				l.add(nums[high]);
				res.add(l);
				low++;
				high--;
				while(low<high&&nums[low]==nums[low-1]){
					low++;
				}
				while(low<high&&nums[high]==nums[high+1]){
					high--;
				}
			}
			else if(sum<0){
				++low;				
			}
			else{
				--high;
			}
		}
	   }
	   return res;
	  
	   
	   }
	
	
	public static void main(String[] args) {
		int[] num={-1, 0, 1, 2, -1, -4};
		threeSum(num);
		//System.out.println(Arrays.toString(threeSum(num).toArray()));
		//System.out.println("chicken");
	}

}
