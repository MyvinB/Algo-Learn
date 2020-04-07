package Array;

/*
 @author Myvin Barboza
 07/04/20 10:40 AM
 */
public class SearchInRotatedSortedArrayLC33 {


    static int search(int a[],int target){
        if(a==null ||a.length==0)return -1;
        int left=0;
        int right =a.length-1;
        while(left<right){
            int midpoint=left+(right-left)/2;
            if(a[midpoint]>a[right]){
                left=midpoint+1;
            }
            else {
                right=midpoint;
            }
        }
        int start=left;
        left=0;
        right=a.length-1;
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
        System.out.println(search(a,0));

    }
}