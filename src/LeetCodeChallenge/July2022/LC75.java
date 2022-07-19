package LeetCodeChallenge.July2022;

public class LC75 {

    public static void main(String[] args) {
        int[] t = new int[]{1,2,2,1,1,1};
    }

    public void sortColors(int[] nums) {
        int l=0;
        int h =nums.length-1;
        int mid = 0;
        while(mid<=h){
            if(nums[mid]==0){
                swap(nums,l++,mid++);
            }else if(nums[mid]==2){
                swap(nums,mid,h--);
            }else mid++;
        }
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
