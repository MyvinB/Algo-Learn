package LeetCode.Array;
/*
 @author Myvin Barboza
 23/05/20 11:50 AM 
 */

public class LC1287ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] a) {
        int n=a.length;
        int req=n/4;

        for(int i=0;i<n-req;i++){
            if(a[i]==a[i+req]){
                return a[i];
            }

        }

        return -1;
    }

    public static void main(String[] args) {

    }
}