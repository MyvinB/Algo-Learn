package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 15/03/20 4:22 PM 
 */
public class FourSumLC18 {

    static List<List<Integer>> fourSum(int[] a, int target) {
        List<List<Integer>> list =new ArrayList<>();
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        for(int i=0;i<a.length;i++){
           for(int j=i+1;j<a.length;j++){
               int low= j+1;
               int high=a.length-1;

               while(low<high){
                   int sum=a[i]+a[j]+a[low]+a[high];
                   if(sum==target){
                       list.add(Arrays.asList(a[i],a[j],a[low],a[high]));
                       while(low<high && a[low]==a[low+1])low++;
                       while(low<high&& a[high]==a[high-1])high--;
                       low++;
                       high--;
                   }
                   else if(sum<target)low++;
                   else if(sum>target)high--;
               }
               while(j+1<a.length &&a[j]==a[j+1])j++;
           }
           while(i+1<a.length&& a[i]==a[i+1])i++;
        }
        return list;
    }

    public static void main(String[] args) {

        int b[]={-3,-2,-1,0,0,1,2,3};
    int a[]={1, 0, -1, 0, -2, 2};

        System.out.println(fourSum(a,0));
    }
}