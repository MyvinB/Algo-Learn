package practise;/*
 @author Myvin Barboza
 25/07/20 3:02 PM 
 */

public class LC33SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int a[]={3,5,1};
        System.out.println(search(a,5));
    }
   static int search(int[] a, int target) {
        int left = 0;
        int right = a.length-1;
       if(a.length==0)return -1;
       if(a.length==1)return a[0]==target?0:-1;

        while(left<right && a[left]==a[right]){
            right--;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(a[mid]>a[right])left=mid+1;
            else right=mid;
        }
        int start=left;
        left=0;
        right=a.length-1;
        if(target>a[a.length-1])right=start;
        else left=start;
        while(left<right){
            int mid=left+(right-left)/2;
            if(a[mid]<target)left=mid+1;
            else right=mid;
        }
        return a[left]==target?left:-1;
    }

}
