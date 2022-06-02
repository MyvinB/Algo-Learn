package TopicWise2022.Array;

public class LC75 {

    private void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public void sortColors(int[] nums) {
        //Making assumpition that everything to left pointer is zero high is 2 and mid is 1
        int l=0,h=nums.length-1,mid=0;
        while(mid<=h){
            if(nums[mid]==0){
                swap(nums,l++,mid++);
            }
            else if(nums[mid]==2){
                swap(nums,h--,mid);
            } else mid++;
        }
    }
}
