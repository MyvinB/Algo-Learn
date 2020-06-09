package LeetCode.DP;
/*
 @author Myvin Barboza
 08/06/20 5:35 PM

 TYPE : SIMILAR to LONGEST INCREASING SUBSEQUENCE LC300
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC368LargestDivisibleSubset {
    //1,2,4,8

    static List<Integer> largestDivisibleSubset(int[] nums) {
        //sorting to get the largest element first
      Arrays.sort(nums);
      int n=nums.length;

      //count array for counting the elements that are divisible
      int count[]=new int[n];
      //storing the index of the elements that are divisble at the index
      int pre[]=new int[n];
      int max=0;
      int index=-1;
      List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
            count[i]=1;
            pre[i]=-1;
            for (int j = i-1; j >=0 ; j--) {
                // divisibility && count including the smaller element is greater than the current count then only update
                if(nums[i]%nums[j]==0  && count[j]+1>count[i] ){
                    count[i]=count[j]+1;
                    pre[i]=j;
                }

            }
            // checking max
            if(count[i]>max){
                max=count[i];
                index=i;
            }
        }

        // just iterating using the pre index
        while(index!=-1){
            list.add(nums[index]);
            // index changes based on pre index
            index=pre[index];
        }
        return list;
    }


    public static void main(String[] args) {
        int a[]={1};
        System.out.println(largestDivisibleSubset(a));
    }
}