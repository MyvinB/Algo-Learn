package LeetCodeChallenge.Feb2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 7:59 PM 2/5/2022
 * Time Taken:
 */
public class LCContest1 {
    public static void main(String[] args) {
        int t[] = new int[]{9,12,5,10,14,3,10};
        System.out.println(Arrays.toString(pivotArray(t,10)));
    }


    public static int minimumSum(int num) {
        int t[] = new int[10];
        int f=0,s=0;
        while(num!=0){
            t[num%10]++;
            num=num/10;
        }
        int low=0,high=9;
        while(low<=high){
            if(t[low]==0)low++;
            if(t[high]==0)high--;
            if(t[low]!=0 && t[high]!=0){
                t[low]--;
                t[high]--;
                if(f==0){
                    f += high;
                    f += low*10;
                }else {
                    s +=high;
                    s +=low*10;
                    break;
                }

            }
        }
        return f+s;
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int pivotCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==pivot){
                pivotCount++;
            }
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot)right.add(nums[i]);
            else if(nums[i]<pivot)left.add(nums[i]);
        }
        int i=0;
        for(;i<left.size();i++){
            nums[i]=left.get(i);
        }

        while(pivotCount!=0){
            nums[i++]=pivot;
            pivotCount--;
        }
        int k=0;
        for(;k<right.size();i++,k++){
            nums[i]=right.get(k);
        }
        return nums;



    }

}
