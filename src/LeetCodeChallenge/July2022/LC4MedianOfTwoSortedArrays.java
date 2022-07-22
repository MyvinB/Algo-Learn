package LeetCodeChallenge.July2022;

public class LC4MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] t = new int[]{1,2};
        int[] p = new int[]{3,4};
        System.out.println(findMedianSortedArrays(t,p));
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

            int maxLeftX = partionX==0?Integer.MIN_VALUE:nums1[partionX-1];
            int minRightX = partionX==x?Integer.MAX_VALUE:nums1[partionX];

            int maxLeftY = partionY ==0? Integer.MIN_VALUE:nums2[partionY-1];
            int minRightY = partionY == y? Integer.MAX_VALUE:nums2[partionY];
            //We found exact half
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if((x+y)%2==0) return (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightY,minRightX))/2;
                else return Math.max(maxLeftX,maxLeftY);
            }
            else if(maxLeftX>minRightY){
                high = partionX;
            }
            else low = partionX+1;
        }
        return 0;

    }
}
