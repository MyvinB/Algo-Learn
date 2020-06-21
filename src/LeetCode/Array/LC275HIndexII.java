package LeetCode.Array;/*
 @author Myvin Barboza
 18/06/20 2:52 PM



 */

public class LC275HIndexII {

                 /*
        *  The algorithm will jump out op while loop. We know for binary search, if it cannot find the target, pointers left and right will be right besides the location which should be the target.
     left
      v
0, 1, 4, 5, 7
   ^
 right*/


    static int hIndex(int[] a) {
        int n=a.length;
        int left=0,right=a.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            // n-md gives you the count of the hindex of the mid value the number of times citations common
            if(a[mid]==n-mid) return n-mid;

else if(a[mid]>n-mid)right=mid-1;
            else if(a[mid]<n-mid) left=mid+1;
        }
       // System.out.println(left);
            //will get the right elements count
        return n-left;

    }
    public static void main(String[] args) {    
            // 4 no of papers having 4 sitations
        //we are finding the square

        // 0 1 4
        int a[] = {0, 1,2};

        System.out.println(hIndex(a));


    }

}
