package LeetCode.Array;

/*
 @author Myvin Barboza
 07/04/20 10:40 AM
 */
public class SearchInRotatedSortedArrayLC33 {

    public static int findMin(int[] a) {
        if(a.length==0)return -1;
        //return value for only finmin problem a[0]
        if(a.length==1)return 0;
        int left = 0;
        int right = a.length-1;
            //code for duplicate elements
        while(left<right&&a[left]==a[right]){
            right--;
        }
        while (left<right){
            int mid = left+(right-left)/2;
            if(a[mid]>a[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }





    static int search(int a[],int target){
        int start=findMin(a);
        if(start==-1)return -1;
        int left=0;
        int right=a.length-1;
        while(left<right&&a[left]==a[right]){
            right--;
        }


        if(target>=a[start] && target<= a[right]){
            left=start;
        } else {
            right=start;
        }
        while(left<=right){
            int midpoint= left+(right-left)/2;
            if(a[midpoint]==target) return midpoint;
            else if(a[midpoint]<target) left=midpoint+1;
            else right=midpoint-1;
        }
        return -1;

    }





    public static void main(String[] args) {
        int a[]={4,5,6,7,0,1,2};
        int a1[]={1,2,1};
        //System.out.println(findMin(a));
        System.out.println(search(a1,2));

    }
}