package LeetCodeChallenge.Oct2022.Array;

public class LC4 {

    public static void main(String[] args) {
        int[] num1 = new int[]{2};
        int[] nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(num1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length;
        int y = nums2.length;
        if(x>y){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = x;
        while(low<=high){
            int partionX = (low+high)/2;
            int partionY = (x+y+1)/2-partionX;
            //Note when we create a partion left side should ideally have the lower elements so left is min
            //right will have the higher elements since respective arrays are sorted we do a cross check  right is max
            //suppose we divide the elements l is x-1 and right is the element itself
            int lX = partionX==0?Integer.MIN_VALUE:nums1[partionX-1];
            int rX = partionX==x?Integer.MAX_VALUE:nums1[partionX];

            int lY = partionY==0?Integer.MIN_VALUE:nums2[partionY-1];
            int rY = partionY==y?Integer.MAX_VALUE:nums2[partionY];
            //using the above line that left is smaller then right but we dont know cross array so we take a cross array check for left and right
            if(lX<=rY && lY<rX){
                        if((x+y)%2==0){
                            return (Math.max(lX,lY) + Math.min(rX,rY))/2.0;
                        }
                        else return Math.max(lX,lY);
            }
            if(lX>rY){
                high = partionX;
            }else low = partionX+1;
        }
        return 0;
    }
}
