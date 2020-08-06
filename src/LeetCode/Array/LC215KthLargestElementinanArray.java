package LeetCode.Array;/*
 @author Myvin Barboza
 06/08/20 6:57 PM 
 */

public class LC215KthLargestElementinanArray {



    //most obvious answer is using a min heap giving you n+klogk time
    //using quick select average time O(n)
    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while(l<h){
            int j=partion(l,h,nums);
            if(j>k)
                h=j-1;
            else if(j<k)l=j+1;
            else break;
        }
        return nums[k];
    }

    static int partion(int l,int h,int a[]){
        int pivot=a[h];
        int i=l-1;
        for(int j=l;j<h;j++){
            if(a[j]<=pivot){
                i++;
                swap(i,j,a);
            }
        }
        swap(i+1,h,a);

        return i+1;
    }

    static void swap(int i,int j,int a[]){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
