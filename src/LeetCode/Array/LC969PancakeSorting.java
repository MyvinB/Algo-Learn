package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC969PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res=new ArrayList<>();
        for(int x=A.length,i;x>0;x--){
            i=0;
            while(A[i]!=x)i++;
            reverse(A,i+1);
            reverse(A,x);
            res.add(i+1);
            res.add(x);
        }
        return res;

    }

    void reverse(int arr[],int idx){
        int i=0,j=idx-1;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        int a[]={3,2,4,1};
        //[3,4,2,3,1,2,1,1]
        LC969PancakeSorting p=new LC969PancakeSorting();

        List<Integer> list=p.pancakeSort(a);
        System.out.println(list);
    }
}
