package practise;/*
 @author Myvin Barboza
 25/07/20 2:07 PM 
 */

public class LC154FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {
        int a[]={3,1,3};
        System.out.println(findMin(a));
    }

    static int findMin(int[] a) {
        if(a.length==0)return -1;
        if(a.length==1)return a[0];
        int left = 0;
        int right = a.length-1;

        while(left<right && a[left]==a[right]){
            right--;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(a[mid]>a[right])left=mid+1;
            else right=mid;
        }
        return a[left];

    }

}
